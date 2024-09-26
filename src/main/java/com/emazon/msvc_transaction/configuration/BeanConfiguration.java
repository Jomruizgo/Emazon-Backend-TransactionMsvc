package com.emazon.msvc_transaction.configuration;


import com.emazon.msvc_transaction.adapters.driven.data.feign.adapter.StockServicePortAdapter;
import com.emazon.msvc_transaction.adapters.driven.data.feign.client.IStockFeignClient;
import com.emazon.msvc_transaction.adapters.driven.data.feign.interceptor.FeignClientInterceptor;
import com.emazon.msvc_transaction.adapters.driven.data.mongodb.adapter.SupplyAdapter;
import com.emazon.msvc_transaction.adapters.driven.data.mongodb.mapper.ISupplyDocumentMapper;
import com.emazon.msvc_transaction.adapters.driven.data.mongodb.repository.ISupplyRepository;
import com.emazon.msvc_transaction.adapters.driven.security.context.AuthenticationContextAdapter;
import com.emazon.msvc_transaction.adapters.driven.security.jwt.JavaJwtAdapter;
import com.emazon.msvc_transaction.domain.api.ISupplyServicePort;
import com.emazon.msvc_transaction.domain.api.usecase.SupplyUseCase;
import com.emazon.msvc_transaction.domain.spi.IAuthenticationContext;
import com.emazon.msvc_transaction.domain.spi.IStockServicePort;
import com.emazon.msvc_transaction.domain.spi.ISupplyPersistencePort;
import com.emazon.msvc_transaction.domain.spi.ITokenServicePort;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class BeanConfiguration {
    private final IStockFeignClient stockFeignClient;
    private final ISupplyRepository supplyRepository;
    private final ISupplyDocumentMapper supplyDocumentMapper;

    public BeanConfiguration(IStockFeignClient stockFeignClient, ISupplyRepository supplyRepository, ISupplyDocumentMapper supplyDocumentMapper) {
        this.stockFeignClient = stockFeignClient;
        this.supplyRepository = supplyRepository;
        this.supplyDocumentMapper = supplyDocumentMapper;
    }


    @Bean
    public ITokenServicePort tokenPort() {
        return new JavaJwtAdapter();
    }

    @Bean
    public IAuthenticationContext authenticationContext() {return  new AuthenticationContextAdapter(); }

    @Bean
    public IStockServicePort stockServicePort() {return new StockServicePortAdapter(stockFeignClient);}

    @Bean
    public ISupplyPersistencePort supplyPersistencePort(){return new SupplyAdapter(supplyRepository, supplyDocumentMapper);
    }

    @Bean
    public ISupplyServicePort supplyServicePort(){return new SupplyUseCase(authenticationContext(),stockServicePort(), supplyPersistencePort());
    }

}
