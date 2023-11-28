package com.example.spt.chamados.Models;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.spt.chamados.Enum.ChamadoStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chamado_tb")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeTicket;
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    private ChamadoStatus status;
    private LocalDateTime dataChamado;

    @ManyToOne
    private User autorDoChamado;

    @Autowired
    public Chamado() {
    }

    public Chamado(String descricao, ChamadoStatus status, LocalDateTime dataChamado, User autorDoChamado) {
        this.descricao = descricao;
        this.status = status;
        this.dataChamado = dataChamado;
        this.autorDoChamado = autorDoChamado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ChamadoStatus getStatus() {
        return status;
    }

    public void setStatusInit() {
        this.status = status.ABERTO;
    }

    public void setStatus(ChamadoStatus status) {
        this.status = status;
    }

    public LocalDateTime getDataChamado() {
        return dataChamado;
    }

    public void setDataChamado(LocalDateTime datChamado) {
        this.dataChamado = datChamado;
    }

    public User getAutorDoChamado() {
        return autorDoChamado;
    }

    public void setAutorDoChamado(User autorDoChamado) {
        this.autorDoChamado = autorDoChamado;
    }

    

    public String getNomeTicket() {
        return nomeTicket;
    }

    public void setNomeTicket(String nomeTicket) {
        this.nomeTicket = nomeTicket;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Chamado other = (Chamado) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
