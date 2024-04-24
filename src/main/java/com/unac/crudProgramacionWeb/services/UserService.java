package com.unac.crudProgramacionWeb.services;

import com.unac.crudProgramacionWeb.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getUsers();
    UserDTO getUserById(Integer id);
    void deleteUser(Integer id);
    UserDTO getUserByName(String name);
    
    
  
}
