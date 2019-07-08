/**
 *
 */
package ml.bootcode.springrestsecurityjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.bootcode.springrestsecurityjwt.models.Authority;

/**
 * @author sunnybatabyal
 *
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
