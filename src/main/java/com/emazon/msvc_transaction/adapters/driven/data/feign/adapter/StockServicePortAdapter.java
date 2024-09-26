package com.emazon.msvc_transaction.adapters.driven.data.feign.adapter;

import com.emazon.msvc_transaction.adapters.driven.data.feign.client.IStockFeignClient;
import com.emazon.msvc_transaction.domain.model.StockRequest;
import com.emazon.msvc_transaction.domain.spi.IStockServicePort;
import org.springframework.http.ResponseEntity;

public class StockServicePortAdapter implements IStockServicePort {
    private final IStockFeignClient stockClient;

    public StockServicePortAdapter(IStockFeignClient stockClient) {
        this.stockClient = stockClient;
    }

    @Override
    public boolean stockIncrease(StockRequest stockRequest) {
        ResponseEntity<Boolean> response = stockClient.incrementStock(stockRequest);
        return response.getBody() != null && response.getBody();
    }
}
