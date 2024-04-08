package com.themoin.overseasremittance.interfaces.user.response;

import com.themoin.overseasremittance.common.response.ResultVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResultVo extends ResultVo {

	private String token;
}
