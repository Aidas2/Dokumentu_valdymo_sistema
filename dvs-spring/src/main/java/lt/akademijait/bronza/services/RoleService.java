package lt.akademijait.bronza.services;


import lt.akademijait.bronza.dto.role.RoleGetCommand;
import lt.akademijait.bronza.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;


    //GET ALL ==========================================================================================================
    @Transactional(readOnly = true)
    public List<RoleGetCommand> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map((role) -> new RoleGetCommand(
                        role.getTitle()
                )).collect(Collectors.toList());
    }

}
