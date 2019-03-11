package lt.akademijait.bronza.services;


import lt.akademijait.bronza.dto.role.RoleCreateCommand;
import lt.akademijait.bronza.dto.role.RoleGetCommand;
import lt.akademijait.bronza.entities.Role;
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

    @Transactional
    public void createRole(RoleCreateCommand roleCreateCommand) {
//        roleRepository.save(new Role(roleCreateCommand.getTitle())) ;


        if(roleRepository.findByTitle(roleCreateCommand.getTitle())==null
               ){
            roleRepository.save(new Role(roleCreateCommand.getTitle())) ;
        } else throw new IllegalArgumentException("This roles already exists");
// &&!roleRepository.findByTitle(roleCreateCommand.getTitle()).getTitle().equals(roleCreateCommand.getTitle())
    }
}
