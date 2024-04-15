package com.themoin.overseasremittance.interfaces.transfer.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteVo {

	private long quoteId;
	private float exchageRate;
	private LocalDateTime expireTime;
	private float targetAmount;
}
