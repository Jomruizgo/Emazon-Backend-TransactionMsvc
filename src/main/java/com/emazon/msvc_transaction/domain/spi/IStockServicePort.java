package com.emazon.msvc_transaction.domain.spi;

import com.emazon.msvc_transaction.domain.model.StockRequest;

public interface IStockServicePort {
    boolean stockIncrease(StockRequest stockRequest);
}
