package com.parkkb.infrastructure.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForexRes {

	private String code;
	private String currencyCode;
	private double basePrice;
	private int currencyUnit;
}
