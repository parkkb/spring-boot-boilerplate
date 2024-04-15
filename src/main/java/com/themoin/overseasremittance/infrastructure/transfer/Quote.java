package com.themoin.overseasremittance.infrastructure.transfer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long quoteId;

	private double exchangeRate;

	private LocalDateTime expirationDate = LocalDateTime.now().plusMinutes(10);

	private BigDecimal targetAmount;

	private String targetCurrency;

	private String userId;
}
