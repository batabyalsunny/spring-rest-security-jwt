/**
 *
 */
package ml.bootcode.springrestsecurityjwt.bootstrap;

import java.util.Arrays;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ml.bootcode.springrestsecurityjwt.models.Authority;
import ml.bootcode.springrestsecurityjwt.models.Role;
import ml.bootcode.springrestsecurityjwt.models.User;
import ml.bootcode.springrestsecurityjwt.repositories.AuthorityRepository;
import ml.bootcode.springrestsecurityjwt.repositories.RoleRepository;
import ml.bootcode.springrestsecurityjwt.repositories.UserRepository;

/**
 * @author sunnyb
 *
 */
@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private boolean done = false;
	private AuthorityRepository authorityRepository;
	private RoleRepository roleRepository;
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	/**
	 * @param authorityRepository
	 * @param roleRepository
	 * @param userRepository
	 * @param passwordEncoder
	 */
	public InitialDataLoader(AuthorityRepository authorityRepository, RoleRepository roleRepository,
			UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.authorityRepository = authorityRepository;
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (done)
			return;

		// Create authorities.
		Authority viewAuthority = new Authority();
		viewAuthority.setName("VIEW");
		Authority downloadAuthority = new Authority();
		downloadAuthority.setName("DOWNLOAD");
		Authority editAuthority = new Authority();
		editAuthority.setName("EDIT");
		Authority uploadAuthority = new Authority();
		uploadAuthority.setName("UPLOAD");

		authorityRepository.save(viewAuthority);
		authorityRepository.save(downloadAuthority);
		authorityRepository.save(editAuthority);
		authorityRepository.save(uploadAuthority);

		// Create roles.
		Role adminRole = new Role();
		adminRole.setName("ADMIN");
		adminRole.setAuthorities(Arrays.asList(viewAuthority, downloadAuthority, editAuthority, uploadAuthority));

		Role userRole = new Role();
		userRole.setName("USER");
		userRole.setAuthorities(Arrays.asList(viewAuthority));

		Role artistRole = new Role();
		artistRole.setName("ARTIST");
		artistRole.setAuthorities(Arrays.asList(viewAuthority, uploadAuthority));

		Role customerRole = new Role();
		customerRole.setName("CUSTOMER");
		customerRole.setAuthorities(Arrays.asList(viewAuthority, downloadAuthority));

		adminRole = roleRepository.save(adminRole);
		userRole = roleRepository.save(userRole);
		artistRole = roleRepository.save(artistRole);
		customerRole = roleRepository.save(customerRole);

		// Create users.
		User adminUser = new User();
		adminUser.setEmail("sunny");
		adminUser.setPassword(passwordEncoder.encode("sunny"));
		adminUser.setRoles(Arrays.asList(adminRole));

		User testUser = new User();
		testUser.setEmail("test");
		testUser.setPassword(passwordEncoder.encode("test"));
		testUser.setRoles(Arrays.asList(artistRole, customerRole));

		adminUser = userRepository.save(adminUser);
		testUser = userRepository.save(testUser);
	}

}
