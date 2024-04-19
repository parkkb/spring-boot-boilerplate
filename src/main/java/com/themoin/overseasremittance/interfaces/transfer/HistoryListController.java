package com.themoin.overseasremittance.interfaces.transfer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HistoryListController {

	@GetMapping("/transfer/history")
	public String hello(){

		System.out.println("====2");
		return "hello";
	}
}
