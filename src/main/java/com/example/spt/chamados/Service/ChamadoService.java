package com.example.spt.chamados.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spt.chamados.Enum.ChamadoStatus;
import com.example.spt.chamados.Models.Chamado;
import com.example.spt.chamados.Repository.ChamadoRepository;

@Service
public class ChamadoService {
    
    @Autowired
    private ChamadoRepository chamadoRepository;

    public List<Chamado> getAutorDoChamado(String user) {
        return chamadoRepository.getAutorDoChamado(user);
    }

    public void createSupportTicket(Chamado createdBy) {
        createdBy.setDataChamado(LocalDateTime.now());
        chamadoRepository.createSupportTicket(createdBy);
    }

    public void alterarStatus(Long id, int status){
        chamadoRepository.alterarStatus(id, status);
    }
}
