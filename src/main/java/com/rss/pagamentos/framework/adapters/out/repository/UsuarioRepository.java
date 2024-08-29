package com.rss.pagamentos.framework.adapters.out.repository;

import com.rss.pagamentos.framework.adapters.out.repository.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    boolean existsByEmail(String email);
}
