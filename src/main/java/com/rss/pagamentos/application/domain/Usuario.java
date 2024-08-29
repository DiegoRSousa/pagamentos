package com.rss.pagamentos.application.domain;


import java.math.BigDecimal;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private BigDecimal saldo;
    private TipoUsuario tipo;

    public Usuario(Long id, String nome, String email, String senha, BigDecimal saldo, TipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public void sacar(BigDecimal valor) {
        if(this.tipo == TipoUsuario.LOJISTA) {
            throw new IllegalArgumentException("Transferencia inválida");
        }

        if(this.saldo.compareTo(valor) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        this.saldo = this.saldo.subtract(valor);
    }

    public void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
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
