package com.example.spt.chamados.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spt.chamados.Models.Chamado;
import com.example.spt.chamados.Models.User;

public interface ChamadoRepository extends JpaRepository<Chamado,Long>{
    List<Chamado> findByAutorDoChamado(User createdBy);
}
