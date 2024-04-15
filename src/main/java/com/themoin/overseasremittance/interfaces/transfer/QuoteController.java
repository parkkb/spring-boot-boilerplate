package com.themoin.overseasremittance.interfaces.transfer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.themoin.overseasremittance.domain.transfer.TransferQuoteService;
import com.themoin.overseasremittance.interfaces.transfer.request.QuoteDto;
import com.themoin.overseasremittance.interfaces.transfer.response.TransferQuoteVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class QuoteController {

	private final TransferQuoteService transferQuoteService;

	@GetMapping("/transfer/quote")
	public TransferQuoteVo getTransferQuote(@RequestBody QuoteDto quoteDto) {
		return transferQuoteService.createQuote(quoteDto);
	}


}