package com.themoin.overseasremittance.interfaces.transfer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.themoin.overseasremittance.common.response.ResultVo;
import com.themoin.overseasremittance.interfaces.transfer.request.RequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RequestController {

	@PostMapping("/transfer/request")
	public ResultVo transferRequest(RequestDto requestDto){

		return null;
	}
}
