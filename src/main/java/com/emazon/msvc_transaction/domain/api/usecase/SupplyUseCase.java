package com.emazon.msvc_transaction.domain.api.usecase;

import com.emazon.msvc_transaction.domain.api.ISupplyServicePort;
import com.emazon.msvc_transaction.domain.model.Supply;
import com.emazon.msvc_transaction.domain.spi.IAuthenticationContext;
import com.emazon.msvc_transaction.domain.spi.IStockServicePort;
import com.emazon.msvc_transaction.domain.spi.ISupplyPersistencePort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public class SupplyUseCase implements ISupplyServicePort {
    private final IAuthenticationContext authenticationContext;
    private final IStockServicePort stockServicePort;
    private final ISupplyPersistencePort supplierServicePort;

    public SupplyUseCase(IAuthenticationContext authenticationContext, IStockServicePort stockServicePort, ISupplyPersistencePort supplierServicePort) {
        this.authenticationContext = authenticationContext;
        this.stockServicePort = stockServicePort;
        this.supplierServicePort = supplierServicePort;
    }

    @Transactional
    @Override
    public void addSupply(Supply supply) {
        supply.setWarehouseAssistantId(authenticationContext.getAuthenticatedUserId());
        supply.setDateSupplied(LocalDateTime.now());

        supplierServicePort.saveSupply(supply);

        stockServicePort.stockIncrease(supply.getArticleId(), supply.getQuantityAdded());

    }
}
