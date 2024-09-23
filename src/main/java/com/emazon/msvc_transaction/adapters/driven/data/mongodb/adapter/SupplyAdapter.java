package com.emazon.msvc_transaction.adapters.driven.data.mongodb.adapter;

import com.emazon.msvc_transaction.adapters.driven.data.mongodb.mapper.ISupplyDocumentMapper;
import com.emazon.msvc_transaction.adapters.driven.data.mongodb.repository.ISupplyRepository;
import com.emazon.msvc_transaction.domain.model.Supply;
import com.emazon.msvc_transaction.domain.spi.ISupplyPersistencePort;

public class SupplyAdapter implements ISupplyPersistencePort {
    private final ISupplyRepository supplyRepository;
    private final ISupplyDocumentMapper supplyDocumentMapper;

    public SupplyAdapter(ISupplyRepository supplyRepository, ISupplyDocumentMapper supplyDocumentMapper) {
        this.supplyRepository = supplyRepository;
        this.supplyDocumentMapper = supplyDocumentMapper;
    }

    @Override
    public void saveSupply(Supply supply) {
        supplyRepository.save(supplyDocumentMapper.toDocument(supply));
    }
}
