package com.emazon.msvc_transaction.domain.spi;

public interface IStockServicePort {
    void stockIncrease(Long articleId, int quantity);
}
