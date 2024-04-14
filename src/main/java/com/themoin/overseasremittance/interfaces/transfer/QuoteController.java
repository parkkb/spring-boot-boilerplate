package com.themoin.overseasremittance.interfaces.transfer;

import org.springframework.web.bind.annotation.RestController;

import com.themoin.overseasremittance.domain.transfer.QuoteService;
import com.themoin.overseasremittance.infrastructure.transfer.TransferService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class QuoteController {

	private final QuoteService quoteService;
	private final TransferService transferService;

	//@GetMapping("/transfer/quote")
	/*public Mono<ResponseEntity<TransferQuoteVo>> getTransferQuote(@RequestBody TransferQuoteDto request) {
		return transferService.getExchangeRate("KRW", request.targetCurrency())
				.map(rate -> quoteService.calculateQuote(request.targetCurrency(), request.amount(), rate))
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.badRequest().build());
	}*/


}
