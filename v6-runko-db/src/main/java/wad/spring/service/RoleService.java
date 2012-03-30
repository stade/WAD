/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import wad.spring.domain.Role;




/**
 *
 * @author stade
 */
public interface RoleService {
    public Role findOne(Long id);
    public void create(Role role);
    public List<Role> list();
    public void setRole(Role role);
    public Long getRoleId(String rolename);
}
