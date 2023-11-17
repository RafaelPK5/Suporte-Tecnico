package com.example.spt.chamados.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spt.chamados.DTOs.UserDTO;
import com.example.spt.chamados.Models.User;
import com.example.spt.chamados.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getLoginUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.loginUser(username);
        
        if (password.equals(user.getPassword())) {
            return ResponseEntity.status(200).body("ok");
        } else {
            return ResponseEntity.status(403).body("Não autorizado");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO usuario) {
        userService.createUsuario(usuario);
        return ResponseEntity.status(200).body("Criado!");
    }

    @GetMapping("/lista")
    public ResponseEntity<List<User>> listaUser() {
        List<User> lista = userService.listarUsuarios();
        return ResponseEntity.ok().body(lista);
    }
}
