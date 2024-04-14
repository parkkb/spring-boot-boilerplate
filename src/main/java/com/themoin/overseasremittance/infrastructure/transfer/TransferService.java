package com.themoin.overseasremittance.infrastructure.transfer;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferService {

	public void processUserRequest() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			String userId = (String) authentication.getPrincipal();
			// 사용자 ID를 이용한 로직 구현
		}
	}



}
