package com.emazon.msvc_transaction.domain.api;

import com.emazon.msvc_transaction.domain.model.Supply;

public interface ISupplyServicePort {
    void addSupply(Supply supply);
}
