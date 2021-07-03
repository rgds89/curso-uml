package com.roger.cursomc.domain;

import com.roger.cursomc.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento{
    private static final long serialVersionUID = 1L;

    private Long numeroParcelas;

    public Long getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Long numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public PagamentoComCartao(){}

    public PagamentoComCartao(Long id, EstadoPagamento estado, Pedido pedido, Long numeroParcelas) {
        super(id, estado, pedido);
        this.numeroParcelas = numeroParcelas;
    }
}
