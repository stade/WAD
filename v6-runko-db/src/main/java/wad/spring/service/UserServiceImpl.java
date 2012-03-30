package wad.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Role;
import wad.spring.domain.User;
import wad.spring.repository.RoleRepository;
import wad.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void create(User user, Long roleId) {
        
        User save = userRepository.save(user);
        
        List<Role> roles = new ArrayList();

        Role role = new Role();
        role.setRolename("student");
        roles.add(role);
        save.setRoles(roles);
        
        userRepository.save(user);
        
        
        /*
        Role role = roleRepository.findOne(roleId);
        
        
        
        role.getUsers().add(user);
        
        List<User> users = role.getUsers();
        
         if (users != null) {
            users.add(user);
        }
        
        List<Role> roles = user.getRoles();
        
        if (roles != null) {
            roles.add(role);
        }
        User save = userRepository.save(user);
        */
    }
  
    @Override
    @Transactional(readOnly = true)
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void setRole(String role) {
    }

    @Override
    public String getRole() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}