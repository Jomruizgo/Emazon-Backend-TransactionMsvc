package com.emazon.msvc_transaction.configuration;


import com.emazon.msvc_transaction.adapters.driven.jwt.JavaJwtAdapter;
import com.emazon.msvc_transaction.domain.spi.ITokenServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {


    @Bean
    public ITokenServicePort tokenPort() {
        return new JavaJwtAdapter();
    }

}
