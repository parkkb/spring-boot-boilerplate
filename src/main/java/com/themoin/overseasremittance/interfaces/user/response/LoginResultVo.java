package com.themoin.overseasremittance.interfaces.user.response;

import com.themoin.overseasremittance.common.response.ResultVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResultVo extends ResultVo {

	private String token;
}
