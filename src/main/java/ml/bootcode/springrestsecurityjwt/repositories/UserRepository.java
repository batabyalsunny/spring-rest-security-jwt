/**
 *
 */
package ml.bootcode.springrestsecurityjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.bootcode.springrestsecurityjwt.models.User;

/**
 * @author sunnybatabyal
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
