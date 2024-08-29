package com.rss.pagamentos.application.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

 class UsuarioTest {
     private final Usuario cliente = new Usuario(
             1L,
             "John Doe",
             "john.doe@example.com",
             "password123",
             new BigDecimal("1000.00"),
             TipoUsuario.CLIENTE
     );

     private final Usuario lojista = new Usuario(
             2L,
             "Jane Doe",
             "jane.doe@example.com",
             "securepassword",
             new BigDecimal("5000.00"),
             TipoUsuario.LOJISTA
     );

    @Test
    void deveSacarQuandoUsuarioClienteESaldoSuficiente() {

        cliente.sacar(new BigDecimal("500.00"));

        assertEquals(new BigDecimal("500.00"), cliente.getSaldo());
    }

    @Test
    void naoDeveSacarQuandoUsuarioLogista() {

        assertThrows(IllegalArgumentException.class, () -> lojista.sacar(new BigDecimal("1000.00")));
    }

    @Test
    void naoDeveSacarQuandoSaldoInsuficiente() {
        assertThrows(IllegalArgumentException.class, () -> cliente.sacar(new BigDecimal("1001.00")));
    }
}
