package lt.akademijait.bronza.repositories;

import lt.akademijait.bronza.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByTitle(String title);


}
