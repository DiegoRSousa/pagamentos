package com.rss.pagamentos.framework.adapters.out.repository;

import com.rss.pagamentos.framework.adapters.out.repository.entity.TransferenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<TransferenciaEntity, Long> {
}
