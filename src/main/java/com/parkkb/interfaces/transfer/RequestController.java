package com.parkkb.interfaces.transfer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parkkb.common.response.ResultVo;
import com.parkkb.interfaces.transfer.request.RequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RequestController {

	@PostMapping("/transfer/request")
	public ResultVo transferRequest(@RequestBody RequestDto requestDto) {

		System.out.println(requestDto);

		return ResultVo.builder()
				.resultCode(HttpStatus.OK.value())
				.resultMsg(HttpStatus.OK.name())
				.build();
	}
}
