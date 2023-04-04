/**
 *
 */
package ml.bootcode.springrestsecurityjwt.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunnybatabyal
 *
 */
@RestController
public class MainController {

	@GetMapping
	public String sayHello() {
		return "Hello";
	}

	@PreAuthorize("#name == authentication.name && hasRole(\"STUDIO\")")
	@GetMapping("view/{name}")
	public String view(@PathVariable("name") String name) {
		return "Viewed";
	}

	@GetMapping("download")
	public String download() {
		return "Downloaded";
	}

	@GetMapping("edit")
	public String edit() {
		return "Edited";
	}

	@GetMapping("me")
	@ResponseBody
	public String me(Authentication authentication) {
		System.out.println(authentication.toString());
		return authentication.getName();
	}
}
