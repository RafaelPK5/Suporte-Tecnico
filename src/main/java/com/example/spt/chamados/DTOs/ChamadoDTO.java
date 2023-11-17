package com.example.spt.chamados.DTOs;

import java.time.LocalDateTime;

import com.example.spt.chamados.Enum.ChamadoStatus;

public class ChamadoDTO {
    private Long id;
    private String descricao;
    private ChamadoStatus status;
    private LocalDateTime dataAtual;

    public ChamadoDTO() {
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

    public void setStatus(ChamadoStatus status) {
        this.status = status;
    }

    public LocalDateTime getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDateTime dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Object getAutorDoChamado() {
        return null;
    }

}
