package com.themoin.overseasremittance.domain.transfer;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.themoin.overseasremittance.infrastructure.transfer.ForexClient;
import com.themoin.overseasremittance.infrastructure.transfer.ForexRes;
import com.themoin.overseasremittance.infrastructure.transfer.QuoteService;
import com.themoin.overseasremittance.interfaces.transfer.request.QuoteDto;
import com.themoin.overseasremittance.interfaces.transfer.response.QuoteVo;
import com.themoin.overseasremittance.interfaces.transfer.response.TransferQuoteVo;

import io.jsonwebtoken.lang.Strings;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@EnableFeignClients(basePackageClasses=com.themoin.overseasremittance.infrastructure.transfer.ForexClient.class)
public class TransferQuoteService {

	private final QuoteService quoteService;
	private final TransferMapper transferMapper;
	private final ForexClient forexClient;

	public TransferQuoteVo createQuote(QuoteDto quoteDto) {

		var forex = getForex(quoteDto.targetCurrency());
		var totalAmount = BigDecimal.valueOf(quoteDto.amount() / forex.getBasePrice());
		return TransferQuoteVo.builder()
				.quoteVo(transferMapper.toQuoteVo(quoteService.createQuote(
						transferMapper.toQuoteEntity(quoteDto, forex.getBasePrice(), calculateFee(quoteDto.targetCurrency(), totalAmount),
								getUserId()))))
				.resultCode(HttpStatus.OK.value())
				.resultMsg(HttpStatus.OK.name())
				.build();
	}

	private ForexRes getForex(String currencyCode){
		return forexClient.getRecentForexRates("FRX.KRW"+currencyCode).get(0);
	}

	private BigDecimal calculateFee(String currency, BigDecimal amount) {
		BigDecimal fixedFee;
		BigDecimal percentageFee;
		if ("USD".equals(currency)) {
			if (amount.compareTo(BigDecimal.valueOf(1000000)) <= 0) {
				fixedFee = BigDecimal.valueOf(1000);
				percentageFee = new BigDecimal("0.002");
			} else {
				fixedFee = BigDecimal.valueOf(3000);
				percentageFee = new BigDecimal("0.001");
			}
		} else if ("JPY".equals(currency)) {
			fixedFee = BigDecimal.valueOf(3000);
			percentageFee = new BigDecimal("0.005");
		} else {
			throw new IllegalArgumentException("Unsupported currency");
		}
		return amount.multiply(percentageFee).add(fixedFee);
	}

	private String getUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userId = Strings.EMPTY;
		if (authentication != null && authentication.isAuthenticated()) {
			userId = (String) authentication.getPrincipal();
		}

		return userId;
	}
}
