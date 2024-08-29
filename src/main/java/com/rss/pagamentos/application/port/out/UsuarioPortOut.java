package com.rss.pagamentos.application.port.out;

import com.rss.pagamentos.application.domain.Usuario;

public interface UsuarioPortOut {

    Usuario save(Usuario novoUsuario);

    Usuario findById(Long id);

    boolean existsByEmail(String email);
}
