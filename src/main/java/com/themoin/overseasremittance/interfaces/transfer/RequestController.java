package com.themoin.overseasremittance.interfaces.transfer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.themoin.overseasremittance.common.response.ResultVo;
import com.themoin.overseasremittance.interfaces.transfer.request.RequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RequestController {

	@PostMapping("/transfer/request")
	public ResultVo transferRequest(@RequestBody  RequestDto requestDto){

		 System.out.println(requestDto);

		return ResultVo.builder()
				.resultCode(HttpStatus.OK.value())
				.resultMsg(HttpStatus.OK.name())
				.build();
	}
}
