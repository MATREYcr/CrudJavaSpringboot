package com.unac.crudProgramacionWeb.services.impl;

import com.unac.crudProgramacionWeb.dao.UserDAO;
import com.unac.crudProgramacionWeb.dto.UserDTO;
import com.unac.crudProgramacionWeb.entity.UserEntity;
import com.unac.crudProgramacionWeb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity userEntity = UserEntity.builder()
                .idUser(userDTO.getIdUser())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .birthdate(userDTO.getBirthdate())
                .build();
        UserEntity savedUser = userDAO.save(userEntity);
        return UserDTO.builder()
                .idUser(savedUser.getIdUser())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .birthdate(savedUser.getBirthdate())
                .build();
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UserEntity> userEntities = userDAO.findAll();
        return  userEntities.stream()
                .map(userEntity -> UserDTO.builder()
                        .idUser(userEntity.getIdUser())
                        .name(userEntity.getName())
                        .email(userEntity.getEmail())
                        .birthdate(userEntity.getBirthdate())
                        .build())
                .toList();
    }
}
