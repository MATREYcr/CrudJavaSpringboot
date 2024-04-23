package com.unac.crudProgramacionWeb.dao;

import com.unac.crudProgramacionWeb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEntity, Integer> {

}
