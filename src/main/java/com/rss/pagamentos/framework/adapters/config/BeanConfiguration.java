package com.rss.pagamentos.framework.adapters.config;

import com.rss.pagamentos.application.port.in.TransferenciaUsecase;
import com.rss.pagamentos.application.port.in.UsuarioUsecase;
import com.rss.pagamentos.application.port.out.TransferenciaPortOut;
import com.rss.pagamentos.application.port.out.UsuarioPortOut;
import com.rss.pagamentos.framework.adapters.out.repository.TransferenciaAdapterOut;
import com.rss.pagamentos.framework.adapters.out.repository.TransferenciaRepository;
import com.rss.pagamentos.framework.adapters.out.repository.UsuarioAdapterOut;
import com.rss.pagamentos.framework.adapters.out.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    TransferenciaUsecase transferenciaUsecase(TransferenciaPortOut transferenciaPortOut) {
        return new TransferenciaUsecase(transferenciaPortOut);
    }

    @Bean
    TransferenciaPortOut transferenciaPortOut(TransferenciaRepository transferenciaRepository) {
        return new TransferenciaAdapterOut(transferenciaRepository);
    }

    @Bean
    UsuarioUsecase usuarioUsecase(UsuarioPortOut usuarioPortOut) {
        return new UsuarioUsecase(usuarioPortOut);
    }

    @Bean
    UsuarioPortOut usuarioPortOut(UsuarioRepository usuarioRepository) {
        return new UsuarioAdapterOut(usuarioRepository);
    }
}
