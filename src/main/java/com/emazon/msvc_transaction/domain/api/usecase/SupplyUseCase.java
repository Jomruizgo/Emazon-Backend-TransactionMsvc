package com.emazon.msvc_transaction.domain.api.usecase;

import com.emazon.msvc_transaction.domain.api.ISupplyServicePort;
import com.emazon.msvc_transaction.domain.exceptions.StockUpdateFailedException;
import com.emazon.msvc_transaction.domain.model.StockRequest;
import com.emazon.msvc_transaction.domain.model.Supply;
import com.emazon.msvc_transaction.domain.spi.IAuthenticationContext;
import com.emazon.msvc_transaction.domain.spi.IStockServicePort;
import com.emazon.msvc_transaction.domain.spi.ISupplyPersistencePort;
import com.emazon.msvc_transaction.domain.util.Constants;

import java.time.LocalDateTime;

public class SupplyUseCase implements ISupplyServicePort {
    private final IAuthenticationContext authenticationContext;
    private final IStockServicePort stockServicePort;
    private final ISupplyPersistencePort supplyPersistencePort;

    public SupplyUseCase(IAuthenticationContext authenticationContext, IStockServicePort stockServicePort, ISupplyPersistencePort supplyPersistencePort) {
        this.authenticationContext = authenticationContext;
        this.stockServicePort = stockServicePort;
        this.supplyPersistencePort = supplyPersistencePort;
    }


    @Override
    public void addSupply(Supply supply) {
        supply.setWarehouseAssistantId(authenticationContext.getAuthenticatedUserId());
        supply.setDateSupplied(LocalDateTime.now());

        StockRequest stockRequest = new StockRequest(supply.getArticleId(), supply.getQuantityAdded());

        boolean stockUpdated = stockServicePort.stockIncrease(stockRequest);

        if (!stockUpdated){
            throw new StockUpdateFailedException(Constants.STOCK_UPDATE_FAILED_MESSAGE);
        }

        supplyPersistencePort.saveSupply(supply);
    }
}
