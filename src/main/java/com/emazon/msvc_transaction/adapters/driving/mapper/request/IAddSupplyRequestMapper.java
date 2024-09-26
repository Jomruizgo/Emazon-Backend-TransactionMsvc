package com.emazon.msvc_transaction.adapters.driving.mapper.request;

import com.emazon.msvc_transaction.adapters.driving.dto.AddSupplyRequestDto;
import com.emazon.msvc_transaction.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IAddSupplyRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "warehouseAssistantId", ignore = true)
    @Mapping(target = "dateSupplied", ignore = true)
    Supply addSupplyRequestToModel(AddSupplyRequestDto addSupplyRequestDto);
}
