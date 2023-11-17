package com.example.spt.chamados.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spt.chamados.DTOs.UserDTO;
import com.example.spt.chamados.Models.User;
import com.example.spt.chamados.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public void createUsuario(UserDTO usuario){
        userRepository.createUsuario(usuario);
    }

    public User loginUser(String usuario){
        return userRepository.loginUser(usuario);
    }
    
    public List<User> listarUsuarios(){
        return userRepository.listarUsuario();
    }
}