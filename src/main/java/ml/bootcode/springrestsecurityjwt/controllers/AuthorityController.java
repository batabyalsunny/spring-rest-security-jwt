/**
 * 
 */
package ml.bootcode.springrestsecurityjwt.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ml.bootcode.springrestsecurityjwt.models.Authority;
import ml.bootcode.springrestsecurityjwt.services.AuthorityService;

/**
 * @author sunnyb
 *
 */
@RestController
@RequestMapping("/authorities")
public class AuthorityController {

	private AuthorityService authorityService;

	@GetMapping("/")
	public List<Authority> getAuthorities() {
		return authorityService.getAuthorities();
	}

	@GetMapping("{id}")
	public Authority getAuthority(@RequestParam Long id) {
		return authorityService.getAuthorityById(id);
	}

	@PostMapping
	public Authority addAuthority(@RequestBody Authority authority) {
		return authorityService.addAuthority(authority);
	}

	@PutMapping("{id}")
	public Authority updateAuthority(@RequestParam Long id, @RequestBody Authority authority) {
		return authorityService.updateAuthority(id, authority);
	}

	@DeleteMapping("{id}")
	public void deleteAuthority(@RequestParam Long id) {
		authorityService.deleteAuthority(id);
	}
}
