package com.parkkb.infrastructure.transfer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "forexClient", url = "https://quotation-api-cdn.dunamu.com/v1")
public interface ForexClient {

	@GetMapping("/forex/recent")
	List<ForexRes> getRecentForexRates(@RequestParam("codes") String codes);
}
