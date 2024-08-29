package com.rss.pagamentos.framework.adapters.in.rest.request;

import com.rss.pagamentos.application.domain.Transferencia;
import com.rss.pagamentos.application.domain.Usuario;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransferenciaRequest (
        @NotNull Long origem,
        @NotNull Long destino,
        @Positive BigDecimal valor) {
    public Transferencia toModel(Usuario origem, Usuario destino) {
        return new Transferencia(origem, destino, valor);
    }
}
