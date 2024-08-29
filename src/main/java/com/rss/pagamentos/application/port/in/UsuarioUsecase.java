package com.rss.pagamentos.application.port.in;

import com.rss.pagamentos.application.domain.Usuario;
import com.rss.pagamentos.application.port.out.UsuarioPortOut;

public class UsuarioUsecase {

    private final UsuarioPortOut usuarioPortOut;

    public UsuarioUsecase(UsuarioPortOut usuarioPortOut) {
        this.usuarioPortOut = usuarioPortOut;
    }

    public Usuario save(Usuario novoUsuario) {
        var usuario = usuarioPortOut.existsByEmail(novoUsuario.getEmail());
        if(usuario) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        return usuarioPortOut.save(novoUsuario);
    }
    public Usuario findById(Long id) {
        return usuarioPortOut.findById(id);
    }
}
