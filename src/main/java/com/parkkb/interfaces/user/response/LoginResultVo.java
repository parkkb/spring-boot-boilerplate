package com.parkkb.interfaces.user.response;

import com.parkkb.common.response.ResultVo;

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
