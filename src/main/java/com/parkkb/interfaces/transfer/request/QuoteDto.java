package com.parkkb.interfaces.transfer.request;

import jakarta.validation.constraints.NotEmpty;

public record QuoteDto(
		@NotEmpty(message = "금액 입력은 필수 입니다.")
		long amount,

		@NotEmpty(message = "환율정보 입력은 필수 입니다.")
		String targetCurrency
)
{
}
