package com.example.spt.chamados.Enum;

public enum ChamadoStatus {
    ABERTO(1),
    PENDENTE(2),
    FECHADO(3);

    private final int valor;

    public int getValor() {
        return valor;
    }

    private ChamadoStatus(int valor) {
        this.valor = valor;
    }

    public static ChamadoStatus fromValor(String valor) {
        for (ChamadoStatus status : values()) {
            if (status.name().equalsIgnoreCase(valor)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Nenhum enum constante correspondente ao valor: " + valor);
    }
}
