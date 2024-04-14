package com.themoin.overseasremittance.infrastructure.transfer;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferService {

	private final ForexClient forexClient;



}
