package lt.akademijait.bronza.repositories;

import lt.akademijait.bronza.entities.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserGroupRepository extends JpaRepository<UserGroup, String> {
    List<UserGroup> findAllByTitle(List<String> titleList);
    UserGroup findByTitle(String title);
    void deleteByTitle(String title);
}

//alternative (find, delete by userGroupId):
/*
public interface UserGroupRepository extends JpaRepository <UserGroup, String> {
    List<UserGroup> findAllByUserGroupId(List<String> userGroupIdList);
    UserGroup findByUserGroupId(String userGroupId);
    void deleteByUserGroupId(String userGroupId);
}
*/


