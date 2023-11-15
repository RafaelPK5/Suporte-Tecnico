package com.example.spt.chamados.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spt.chamados.DTOs.UserDTO;
import com.example.spt.chamados.Models.User;
import com.example.spt.chamados.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(UserDTO usuario){
        User slkt = new User();
        slkt.setUsername(usuario.getUsername());
        slkt.setPassword(usuario.getPassword());
        return slkt;
    }
}

    
