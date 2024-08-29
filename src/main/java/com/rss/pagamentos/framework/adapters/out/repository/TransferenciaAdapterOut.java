package com.rss.pagamentos.framework.adapters.out.repository;

import com.rss.pagamentos.application.domain.Transferencia;
import com.rss.pagamentos.application.port.out.TransferenciaPortOut;
import com.rss.pagamentos.framework.adapters.out.repository.entity.TransferenciaEntity;

public class TransferenciaAdapterOut implements TransferenciaPortOut {

    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaAdapterOut(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    @Override
    public Transferencia save(Transferencia transferencia) {
        var transferenciaEntity = new TransferenciaEntity(transferencia);
        return transferenciaRepository.save(transferenciaEntity).toModel();
    }
}
