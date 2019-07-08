/**
 *
 */
package ml.bootcode.springrestsecurityjwt.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ml.bootcode.springrestsecurityjwt.dtos.UserDto;
import ml.bootcode.springrestsecurityjwt.models.User;
import ml.bootcode.springrestsecurityjwt.repositories.UserRepository;

/**
 * @author sunnybatabyal
 *
 */
@Service
public class UserService {

	private UserRepository userRepository;

	public List<UserDto> getUsers() {
		return userRepository.findAll().stream().map(user -> mapUserToUserDto(user)).collect(Collectors.toList());
	}

	public UserDto getUserById(Long id) {
		return mapUserToUserDto(validateUserOptional(userRepository.findById(id)));
	}

	public UserDto getUserByEmail(String email) {
		return mapUserToUserDto(validateUserOptional(userRepository.findByEmail(email)));
	}

	public UserDto addUser(UserDto userDto) {
		if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
			throw new RuntimeException("Email Id already exists");
		}

		User user = new User();

		return mapUserToUserDto(userRepository.save(mapUserDtoToUser(user, userDto)));
	}

	public UserDto updateUser(Long id, UserDto userDto) {
		return mapUserToUserDto(
				userRepository.save(mapUserDtoToUser(validateUserOptional(userRepository.findById(id)), userDto)));
	}

	public void deleteUser(Long id) {
		userRepository.delete(validateUserOptional(userRepository.findById(id)));
	}

	public User validateUserOptional(Optional<User> userOptional) {
		if (!userOptional.isPresent()) {
			throw new RuntimeException("User Not Found");
		}

		return userOptional.get();
	}

	public UserDto mapUserToUserDto(User user) {
		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setRoles(user.getRoles());

		return userDto;
	}

	public User mapUserDtoToUser(User user, UserDto userDto) {
		user.setEmail(userDto.getEmail());
		user.setRoles(userDto.getRoles());

		return user;
	}
}
