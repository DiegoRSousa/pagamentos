package com.rss.pagamentos.framework.adapters.out.repository.entity;

import com.rss.pagamentos.application.domain.Transferencia;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transferencia")
public class TransferenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private UsuarioEntity origem;
    @ManyToOne
    private UsuarioEntity destino;
    private BigDecimal valor;
    private LocalDateTime data;

    public TransferenciaEntity() { }

    public TransferenciaEntity(Transferencia transferencia) {
        this.id = transferencia.getId();
        this.origem = new UsuarioEntity(transferencia.getOrigem());
        this.destino = new UsuarioEntity(transferencia.getDestino());
        this.valor = transferencia.getValor();
        this.data = transferencia.getData();
    }

    public Transferencia toModel() {
        return new Transferencia(id, origem.toModel(), destino.toModel(), valor, data);
    }

    public Long getId() {
        return id;
    }

    public UsuarioEntity getOrigem() {
        return origem;
    }

    public UsuarioEntity getDestino() {
        return destino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }
}
