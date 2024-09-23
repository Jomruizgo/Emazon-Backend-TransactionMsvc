package com.emazon.msvc_transaction.domain.spi;

import com.emazon.msvc_transaction.domain.model.Supply;

public interface ISupplyPersistencePort {
    void saveSupply(Supply supply);
}
