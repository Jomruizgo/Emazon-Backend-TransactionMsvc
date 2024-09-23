package com.emazon.msvc_transaction.adapters.driven.data.feign.adapter;

import com.emazon.msvc_transaction.adapters.driven.data.feign.client.IStockFeignClient;
import com.emazon.msvc_transaction.domain.spi.IStockServicePort;

public class StockServicePortAdapter implements IStockServicePort {
    private final IStockFeignClient stockClient;

    public StockServicePortAdapter(IStockFeignClient stockClient) {
        this.stockClient = stockClient;
    }

    @Override
    public void stockIncrease(Long articleId, int quantity) {
        stockClient.incrementStock(articleId, quantity);
    }
}
