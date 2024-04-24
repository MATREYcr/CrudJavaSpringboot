package com.unac.crudProgramacionWeb.controllers;

import com.unac.crudProgramacionWeb.dto.ResponseDTO;
import com.unac.crudProgramacionWeb.dto.UserDTO;
import com.unac.crudProgramacionWeb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/guardar")
    public ResponseEntity<UserDTO> savedUserController(@RequestBody UserDTO obj) {

        ResponseDTO responseDTO = new ResponseDTO();
        try {
            UserDTO user = userService.saveUser(obj);
            responseDTO.setStatus(201);
            responseDTO.setMessage("User created succesfully");
            responseDTO.setResult(user);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            responseDTO.setStatus(500);
            responseDTO.setMessage("Internal Server error");
            return ResponseEntity.status(500).body(responseDTO);
        }

    }

    @GetMapping("/Listar")
    public ResponseEntity<List<UserDTO>> getAllUserController() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("Listar/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable("id") Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            UserDTO user = userService.getUserById(id);
            responseDTO.setStatus(200);
            responseDTO.setMessage("User fetch successfully");
            responseDTO.setResult(user);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            responseDTO.setStatus(500);
            responseDTO.setMessage("Ocurrio un error en el servidor");
            return ResponseEntity.status(500).body(responseDTO);
        }

    }

    @DeleteMapping("Listar/{id}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable("id") Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            userService.deleteUser(id);
            responseDTO.setStatus(200);
            responseDTO.setMessage("User Delete successfully");
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            responseDTO.setStatus(500);
            responseDTO.setMessage("Ocurrio un error en el servidor");
            return ResponseEntity.status(500).body(responseDTO);
        }
    }

    @GetMapping("getname/{name}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable("name") String name) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            UserDTO user = userService.getUserByName(name);
            responseDTO.setStatus(200);
            responseDTO.setMessage("User fetch successfully");
            responseDTO.setResult(user);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            responseDTO.setStatus(500);
            responseDTO.setMessage("Ocurrio un error en el servidor");
            return ResponseEntity.status(500).body(responseDTO);
        }
    }
}
