/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.spring.domain.Role;
import wad.spring.repository.RoleRepository;



/**
 *
 * @author stade
 */

@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleRepository roleRepository;

    
    @Override 
    @Transactional
    public void create(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public Role findOne(Long id) {
        return roleRepository.findOne(id);
    }

    @Override
    @Transactional
    public void setRole(Role role) {
        roleRepository.save(role);
        
    }

    @Override
    public Long getRoleId(String rolename) {
        
        Role role = null;
        List<Role> roleList = roleRepository.findAll();
        
        for (Role r: roleList) {
            if (r.getRolename().equalsIgnoreCase(rolename)) {
                role = r;
                break;
            }
        }
       
        return role.getId();
    }
}
