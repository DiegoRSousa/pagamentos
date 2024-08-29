package com.rss.pagamentos.framework.adapters.out.repository;

import com.rss.pagamentos.application.domain.Usuario;
import com.rss.pagamentos.application.port.out.UsuarioPortOut;
import com.rss.pagamentos.framework.adapters.out.repository.entity.UsuarioEntity;

public class UsuarioAdapterOut  implements UsuarioPortOut {

    private final UsuarioRepository usuarioRepository;

    public UsuarioAdapterOut(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario save(Usuario novoUsuario) {
        var usuario = usuarioRepository.save(new UsuarioEntity(novoUsuario));
        return usuario.toModel();
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    @Override
    public Usuario findById(Long id) {
        var usuarioEntity = usuarioRepository.findById(id);
        return usuarioEntity.map(UsuarioEntity::toModel).orElseThrow(()
            -> new RuntimeException("Usuário não encontrado"));
    }
}
