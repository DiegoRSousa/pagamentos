package com.rss.pagamentos.framework.adapters.in.rest;

import com.rss.pagamentos.application.domain.Transferencia;
import com.rss.pagamentos.application.port.in.TransferenciaUsecase;
import com.rss.pagamentos.application.port.in.UsuarioUsecase;
import com.rss.pagamentos.framework.adapters.in.rest.request.TransferenciaRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaAdapterIn {

    private TransferenciaUsecase transferenciaUsecase;

    private UsuarioUsecase usuarioUsecase;

    public TransferenciaAdapterIn(TransferenciaUsecase transferenciaUsecase, UsuarioUsecase usuarioUsecase) {
        this.transferenciaUsecase = transferenciaUsecase;
        this.usuarioUsecase = usuarioUsecase;
    }

    @PostMapping
    public ResponseEntity<Transferencia> transferir(@Valid @RequestBody TransferenciaRequest request,
                                                    UriComponentsBuilder uriBuilder) {
        var origem = usuarioUsecase.findById(request.origem());
        var destino = usuarioUsecase.findById(request.destino());

        var transferencia = transferenciaUsecase.transferir(request.toModel(origem, destino));

        URI location = uriBuilder.path("/transferencias/{id}")
                .buildAndExpand(transferencia.getId())
                .toUri();

        return ResponseEntity.created(location).build();


    }
}