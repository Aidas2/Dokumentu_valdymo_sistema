package lt.akademijait.bronza.repositories;

import lt.akademijait.bronza.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {
    User findByUsername(String username);
    void deleteByUsername(String username);
    List<User> findAllByUsernameIn(List<String> users);
    
}
