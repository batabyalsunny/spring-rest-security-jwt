/**
 *
 */
package ml.bootcode.springrestsecurityjwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.bootcode.springrestsecurityjwt.models.Role;

/**
 * @author sunnybatabyal
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(String name);
}
