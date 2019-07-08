/**
 *
 */
package ml.bootcode.springrestsecurityjwt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ml.bootcode.springrestsecurityjwt.models.Role;
import ml.bootcode.springrestsecurityjwt.repositories.RoleRepository;

/**
 * @author sunnybatabyal
 *
 */
@Service
public class RoleService {

	private RoleRepository roleRepository;

	public List<Role> getRoles() {
		return null;
	}

	public Role getRoleById(Long id) {
		return null;
	}

	public Role getRoleByName(String name) {
		return null;
	}

	public Role addRole() {
		return null;
	}

	public Role updateRole(Role role) {
		return null;
	}

	public void deleteRole() {
	}
}
