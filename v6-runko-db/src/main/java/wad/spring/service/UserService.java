/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.util.List;
import wad.spring.domain.User;

/**
 *
 * @author stade
 */
public interface UserService {

    public User findOne(Long id);
    public void create(User user, Long roleId);
    public List<User> list();
    public void setRole(String role);
    public String getRole();

}
