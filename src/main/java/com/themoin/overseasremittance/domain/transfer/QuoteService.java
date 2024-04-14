package com.themoin.overseasremittance.domain.transfer;

import java.math.BigDecimal;
import java.util.Currency;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuoteService {

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
}
