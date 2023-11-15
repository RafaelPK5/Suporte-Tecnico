package com.example.spt.chamados.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spt.chamados.Models.Chamado;
import com.example.spt.chamados.Models.User;
import com.example.spt.chamados.Repository.ChamadoRepository;

@Service
public class ChamadoService {
    
    @Autowired
    private ChamadoRepository chamadoRepository;

    public List<Chamado> getAutorDoChamado(User user) {
        return chamadoRepository.findByAutorDoChamado(user);
    }


    public Chamado createSupportTicket(User createdBy, String description) {
        Chamado ticket = new Chamado();
        ticket.setAutorDoChamado(createdBy);
        ticket.setDescricao(description);
        ticket.setStatusInit();
        ticket.setDatAtual(LocalDateTime.now());
        return chamadoRepository.save(ticket);
    }
}
