package com.rss.pagamentos.application.port.out;

import com.rss.pagamentos.application.domain.Transferencia;

public interface TransferenciaPortOut {

    Transferencia save(Transferencia transferencia);
}
