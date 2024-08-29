package com.rss.pagamentos.application.port.in;

import com.rss.pagamentos.application.domain.Transferencia;
import com.rss.pagamentos.application.port.out.TransferenciaPortOut;

public class TransferenciaUsecase {

    private final TransferenciaPortOut transferenciaPortOut;

    public TransferenciaUsecase(TransferenciaPortOut transferenciaPortOut) {
        this.transferenciaPortOut = transferenciaPortOut;
    }

    public Transferencia transferir(Transferencia transferencia) {
        transferencia.transferir();
        return transferenciaPortOut.save(transferencia);
    }
}