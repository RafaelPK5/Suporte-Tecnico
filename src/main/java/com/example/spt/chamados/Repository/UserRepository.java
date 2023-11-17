package com.example.spt.chamados.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.example.spt.chamados.DTOs.UserDTO;
import com.example.spt.chamados.Models.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class UserRepository {
    @Autowired
    private EntityManager em;

    @Transactional
    public void createUsuario(UserDTO usuario) {
        em.createNativeQuery("INSERT INTO user_tb(username,password) values(?,?)")
                .setParameter(1, usuario.getUsername())
                .setParameter(2, usuario.getPassword())
                .executeUpdate();
    }

    public User loginUser(String username) {
        User result = (User) em.createNativeQuery("SELECT * FROM user_tb u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
        return result;
    }

    @SuppressWarnings("unchecked")
    public List<User> listarUsuario() {
        return em.createNativeQuery("SELECT * FROM user_tb", User.class)
                .getResultList();
    }
}