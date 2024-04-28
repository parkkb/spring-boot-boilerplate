package com.parkkb.interfaces.transfer.request;

import jakarta.validation.constraints.NotEmpty;

public record RequestDto(

		@NotEmpty(message = "견적서 아이디를 입력해주세요")
		long quoteId
) {
}
