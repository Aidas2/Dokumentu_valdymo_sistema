package lt.akademijait.bronza.repositories;

import lt.akademijait.bronza.entities.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
    Set<UserGroup> findAllByTitle(HashSet<String> titleList);
    UserGroup findByTitle(String title);
    void deleteByTitle(String title);
}

//alternative (find, delete by userGroupId):
/*
public interface UserGroupRepository extends JpaRepository <UserGroup, Long> {
    List<UserGroup> findAllByUserGroupId(List<String> userGroupIdList);
    UserGroup findByUserGroupId(String userGroupId);
    void deleteByUserGroupId(String userGroupId);
}
*/


