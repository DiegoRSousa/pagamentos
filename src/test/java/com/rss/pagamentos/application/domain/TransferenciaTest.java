package com.rss.pagamentos.application.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransferenciaTest {

    private final Usuario origem = new Usuario(
            1L,
            "John Doe",
            "john.doe@example.com",
            "password123",
            new BigDecimal("1000.00"),
            TipoUsuario.CLIENTE
    );

    private final Usuario destino = new Usuario(
            2L,
            "Jane Doe",
            "jane.doe@example.com",
            "securepassword",
            new BigDecimal("5000.00"),
            TipoUsuario.LOJISTA
    );


    @Test
    void deveTranferirQuandoSaldoSuficiente() {

        var transferencia = new Transferencia(origem, destino, BigDecimal.TEN);

        transferencia.transferir();

        assertEquals(new BigDecimal("5010.00"), destino.getSaldo());
        assertEquals(new BigDecimal("990.00"), origem.getSaldo());


    }

}