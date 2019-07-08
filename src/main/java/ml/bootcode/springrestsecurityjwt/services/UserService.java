/**
 *
 */
package ml.bootcode.springrestsecurityjwt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ml.bootcode.springrestsecurityjwt.dtos.UserDto;
import ml.bootcode.springrestsecurityjwt.repositories.UserRepository;

/**
 * @author sunnybatabyal
 *
 */
@Service
public class UserService {

	private UserRepository userRepository;

	public List<UserDto> getUsers() {
		return null;
	}

	public UserDto getUserById(Long id) {
		return null;
	}

	public UserDto getUserByEmail(String email) {
		return null;
	}

	public UserDto addUser() {
		return null;
	}

	public UserDto updateUser(UserDto userDto) {
		return null;
	}

	public void deleteUser() {
	}
}
