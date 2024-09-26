package com.emazon.msvc_transaction.adapters.driving.controller;

import com.emazon.msvc_transaction.adapters.driving.dto.AddSupplyRequestDto;
import com.emazon.msvc_transaction.adapters.driving.mapper.request.IAddSupplyRequestMapper;
import com.emazon.msvc_transaction.domain.api.ISupplyServicePort;
import com.emazon.msvc_transaction.domain.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.API_SUPPLY_PATH)
public class SupplyController {
    private final ISupplyServicePort supplyServicePort;
    private final IAddSupplyRequestMapper addSupplyRequestMapper;

    public SupplyController(ISupplyServicePort supplyServicePort, IAddSupplyRequestMapper addSupplyRequestMapper) {
        this.supplyServicePort = supplyServicePort;
        this.addSupplyRequestMapper = addSupplyRequestMapper;
    }

    @PostMapping("")
    public ResponseEntity<String> addSupply(@RequestBody AddSupplyRequestDto request){
        supplyServicePort.addSupply(addSupplyRequestMapper.addSupplyRequestToModel(request));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
