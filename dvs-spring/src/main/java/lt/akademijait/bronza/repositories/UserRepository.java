package lt.akademijait.bronza.repositories;

import lt.akademijait.bronza.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {
    User findByUsername(String username);
//    User findById(Long id);
    void deleteByUsername(String username);
//    User findByUserGroup(String title);
    List<User> findAllByUsernameIn(List<String> users);

    
}
