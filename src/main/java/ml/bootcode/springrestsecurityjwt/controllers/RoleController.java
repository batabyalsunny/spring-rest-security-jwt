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

import ml.bootcode.springrestsecurityjwt.models.Role;
import ml.bootcode.springrestsecurityjwt.services.RoleService;

/**
 * @author sunnyb
 *
 */
@RestController
@RequestMapping("roles")
public class RoleController {

	private RoleService roleService;

	@GetMapping
	public List<Role> getRoles() {
		return roleService.getRoles();
	}

	@GetMapping("{id}")
	public Role getRole(@RequestParam Long id) {
		return roleService.getRoleById(id);
	}

	@PostMapping
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}

	@PutMapping("{id}")
	public Role updateRole(@RequestParam Long id, @RequestBody Role role) {
		return roleService.updateRole(id, role);
	}

	@DeleteMapping("{id}")
	public void deleteRole(@RequestParam Long id) {
		roleService.deleteRole(id);
	}
}
