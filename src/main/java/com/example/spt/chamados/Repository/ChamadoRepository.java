package com.example.spt.chamados.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spt.chamados.Models.Chamado;
import com.example.spt.chamados.Models.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ChamadoRepository {

    @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Chamado> getAutorDoChamado(String user) {
        List<Chamado> listaChamado = em.createNativeQuery("SELECT * FROM chamado_tb c WHERE c.autor_do_chamado = :username", Chamado.class)
        .setParameter("username", user)
        .getResultList();
        return listaChamado;
    }

    @Transactional
    public void createSupportTicket(Chamado createdBy) {
        em.createNativeQuery("INSERT INTO chamado_tb(id,descricao,status,data_atual,autor_do_chamado_id) values(null,?,?,?,?)")
        .setParameter(1, createdBy.getDescricao())
        .setParameter(2, 1)
        .setParameter(3, createdBy.getDatAtual())
        .setParameter(4, createdBy.getAutorDoChamado().getId())
        .executeUpdate();
    }
}
