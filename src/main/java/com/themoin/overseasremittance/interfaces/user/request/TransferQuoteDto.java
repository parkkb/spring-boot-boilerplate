package com.themoin.overseasremittance.interfaces.user.request;

import java.math.BigDecimal;

public record TransferQuoteDto(
		BigDecimal amount,
		String targetCurrency
) {
}
