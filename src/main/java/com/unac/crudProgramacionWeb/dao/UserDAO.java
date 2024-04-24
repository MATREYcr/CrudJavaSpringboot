package com.unac.crudProgramacionWeb.dao;

import com.unac.crudProgramacionWeb.entity.UserEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDAO extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT u FROM UserEntity u WHERE u.name = ?1")
    UserEntity findByname(String name);
    
    @Query(value = "select * from users where name = ?1", nativeQuery = true)
    List<Object[]> findByName(String name);

}
