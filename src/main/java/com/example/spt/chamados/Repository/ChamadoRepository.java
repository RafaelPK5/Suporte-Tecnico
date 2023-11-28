package com.example.spt.chamados.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spt.chamados.Enum.ChamadoStatus;
import com.example.spt.chamados.Models.Chamado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Repository
public class ChamadoRepository {

    @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Chamado> getAutorDoChamado(String user) {
        List<Chamado> listaChamado = em.createNativeQuery(
                "SELECT c.id, c.data_atual, c.descricao, c.status, c.autor_do_chamado_id FROM chamado_tb c JOIN user_tb u ON c.autor_do_chamado_id = u.id WHERE u.username = :user",
                Chamado.class)
                .setParameter("user", user)
                .getResultList();
        return listaChamado;
    }

    @Transactional
    public void createSupportTicket(Chamado createdBy) {
        em.createNativeQuery(
                "INSERT INTO chamado_tb(id,descricao,status,data_atual,autor_do_chamado_id) values(null,?,?,?,?)")
                .setParameter(1, createdBy.getDescricao())
                .setParameter(2, 1)
                .setParameter(3, createdBy.getDataChamado())
                .setParameter(4, createdBy.getAutorDoChamado().getId())
                .executeUpdate();
    }

    @Transactional
    public void alterarStatus(Long id, int status) {
        Chamado ticket = em.find(Chamado.class, id);

        if (ticket == null) {
            throw new EntityNotFoundException("Chamado não encontrado ou não existente");
        }

        em.createNativeQuery("UPDATE chamado_tb SET status = ? WHERE id = ?")
                .setParameter(1, status)
                .setParameter(2, id)
                .executeUpdate();
    }
}
