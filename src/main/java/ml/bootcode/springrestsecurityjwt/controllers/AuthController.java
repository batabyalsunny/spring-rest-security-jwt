/**
 * 
 */
package ml.bootcode.springrestsecurityjwt.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ml.bootcode.springrestsecurityjwt.dtos.LoginRequestDto;
import ml.bootcode.springrestsecurityjwt.dtos.LoginResponseDto;
import ml.bootcode.springrestsecurityjwt.dtos.UserDto;
import ml.bootcode.springrestsecurityjwt.services.UserService;

/**
 * @author sunnyb
 *
 */
@RestController
@RequestMapping("auth")
public class AuthController {

	private UserService userService;

	/**
	 * @param userService
	 */
	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("login")
	public LoginResponseDto login(LoginRequestDto loginRequestDto) {
		return null;
	}

	@PostMapping("register")
	public UserDto register(UserDto userDto) {
		return userService.addUser(userDto);
	}
}
