package com.themoin.overseasremittance.interfaces.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferQuoteVo {

	private String code;
	private String currencyCode;
	private double basePrice;
	private int currencyUnit;

}
