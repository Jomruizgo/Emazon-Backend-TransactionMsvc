package com.emazon.msvc_transaction.adapters.driven.data.mongodb.mapper;

import com.emazon.msvc_transaction.adapters.driven.data.mongodb.document.SupplyDocument;
import com.emazon.msvc_transaction.domain.model.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISupplyDocumentMapper {

    Supply toModel(SupplyDocument supplyDocument);

    SupplyDocument toDocument(Supply supply);
}
