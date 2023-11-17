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
    public List<Chamado> getAutorDoChamado(User user) {
        List<Chamado> listaChamado = em.createNativeQuery("SELECT * FROM chamado WHERE user_id = :uid", Chamado.class)
        .setParameter("uid", user.getId())
        .getResultList();
        return listaChamado;
    }

    @Transactional
    public void createSupportTicket(Chamado createdBy) {
        em.createNativeQuery("INSERT INTO chamado(id,descricao,status,data_atual,autor_do_chamado) values(null,?,?,?,?)")
        .setParameter(1, createdBy.getDescricao())
        .setParameter(2, "ABERTO")
        .setParameter(3, createdBy.getDatAtual())
        .setParameter(4, createdBy.getAutorDoChamado())
        .executeUpdate();
    }
}
