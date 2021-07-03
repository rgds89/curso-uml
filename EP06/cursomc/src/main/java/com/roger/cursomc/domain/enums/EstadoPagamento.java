package com.roger.cursomc.domain.enums;

public enum EstadoPagamento {
    PENDENTE("P", "Pagamento Pendente"),
    QUITADO("Q", "Pagamento Quitado"),
    CANCELADO("C", "Pagamento Cancelado");

    private String estado;
    private String descricao;

    public String getEstado() {
        return estado;
    }

    public String getDescricao() {
        return descricao;
    }

    EstadoPagamento(String estado, String descricao) {
        this.estado = estado;
        this.descricao = descricao;
    }

    public static EstadoPagamento toEnum(String estado){
        if(estado == null){
            return null;
        }

        for(EstadoPagamento x : EstadoPagamento.values()){
            if(estado.equals(x.getEstado())){
                return x;
            }
        }
        throw new IllegalArgumentException("Estado pagamento inválido: " + estado);
    }
}
