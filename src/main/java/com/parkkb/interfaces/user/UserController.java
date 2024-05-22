package com.parkkb.interfaces.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkkb.interfaces.user.response.UserResultVo;

@RestController
public class UserController {

	//controller test code 용 sample (단순 select)
	@GetMapping("/user/info")
	public UserResultVo getUserInfo() {
		return new UserResultVo();
	}
}
