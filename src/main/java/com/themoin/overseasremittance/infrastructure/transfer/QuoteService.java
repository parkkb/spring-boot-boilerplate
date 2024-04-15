package com.themoin.overseasremittance.infrastructure.transfer;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuoteService {

	private final QuoteRepository quoteRepository;
	private final ForexClient forexClient;

	public Quote createQuote(Quote quote) {
		return quoteRepository.save(quote);
	}

}