package com.rss.pagamentos.application.port.in;

import com.rss.pagamentos.application.domain.TipoUsuario;
import com.rss.pagamentos.application.domain.Usuario;
import com.rss.pagamentos.application.port.out.UsuarioPortOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UsuarioUsecaseTest {

    private final Usuario lojista = new Usuario(
            2L,
            "Jane Doe",
            "jane.doe@example.com",
            "securepassword",
            new BigDecimal("5000.00"),
            TipoUsuario.LOJISTA
    );

    @InjectMocks
    private  UsuarioUsecase usuarioUsecase;

    @Mock
    private UsuarioPortOut usuarioPortOut;


    @Test
    void deveCadastrarUsuarioQuandoNaoExistirComMesmoEmail() {
        Mockito.when(usuarioPortOut.existsByEmail(lojista.getEmail())).thenReturn(false);

        assertDoesNotThrow(() -> usuarioUsecase.save(lojista));
    }

    @Test
    void naoDeveCadastrarUsuarioQuandoExistirComMesmoEmail() {
        Mockito.when(usuarioPortOut.existsByEmail(lojista.getEmail())).thenReturn(true);

        assertThrows( IllegalArgumentException.class, () -> usuarioUsecase.save(lojista), "Email já cadastrado");
    }

}