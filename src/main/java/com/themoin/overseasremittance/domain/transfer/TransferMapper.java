package com.themoin.overseasremittance.domain.transfer;

import java.math.BigDecimal;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.themoin.overseasremittance.infrastructure.transfer.Quote;
import com.themoin.overseasremittance.interfaces.transfer.request.QuoteDto;
import com.themoin.overseasremittance.interfaces.transfer.response.QuoteVo;

@Mapper(componentModel = "spring")
public interface TransferMapper {

	@Mapping(target = "expirationDate", ignore = true)
	Quote toQuoteEntity(QuoteDto quoteDto, double exchageRate, BigDecimal targetAmount, String userId);

	QuoteVo toQuoteVo(Quote quote);
}
