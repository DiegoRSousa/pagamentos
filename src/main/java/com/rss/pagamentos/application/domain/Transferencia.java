package com.rss.pagamentos.application.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class Transferencia {

    private Long id;
    private Usuario origem;
    private Usuario destino;
    private BigDecimal valor;
    private LocalDateTime data;

    public Transferencia(Usuario origem, Usuario destino, BigDecimal valor) {

        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    public Transferencia(Long id, Usuario origem, Usuario destino, BigDecimal valor, LocalDateTime data) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.data = data;
    }

    public void transferir() {
        this.origem.sacar(valor);
        this.destino.depositar(valor);
    }

    public Long getId() {
        return id;
    }

    public Usuario getOrigem() {
        return origem;
    }

    public Usuario getDestino() {
        return destino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }
}
