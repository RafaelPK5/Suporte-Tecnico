package com.example.spt.chamados.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spt.chamados.Models.User;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsername(String username);
}
