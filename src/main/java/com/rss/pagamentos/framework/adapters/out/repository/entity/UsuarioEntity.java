package com.rss.pagamentos.framework.adapters.out.repository.entity;

import com.rss.pagamentos.application.domain.TipoUsuario;
import com.rss.pagamentos.application.domain.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private BigDecimal saldo;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.saldo = usuario.getSaldo();
        this.tipo = usuario.getTipo();
    }

    public Usuario toModel() {
        return new Usuario(id, nome, email, senha, saldo, tipo);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }
}
