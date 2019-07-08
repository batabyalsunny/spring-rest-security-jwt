/**
 *
 */
package ml.bootcode.springrestsecurityjwt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ml.bootcode.springrestsecurityjwt.models.Authority;
import ml.bootcode.springrestsecurityjwt.repositories.AuthorityRepository;

/**
 * @author sunnybatabyal
 *
 */
@Service
public class AuthorityService {

	private AuthorityRepository authorityRepository;

	public List<Authority> getAuthority() {
		return null;
	}

	public Authority getAuthorityById(Long id) {
		return null;
	}

	public Authority getAuthorityByName(String name) {
		return null;
	}

	public Authority addAuthority() {
		return null;
	}

	public Authority updateAuthority(Authority authority) {
		return null;
	}

	public void deleteAuthority() {
	}
}
