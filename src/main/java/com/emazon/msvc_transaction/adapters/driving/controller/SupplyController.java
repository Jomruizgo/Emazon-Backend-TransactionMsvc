package com.emazon.msvc_transaction.adapters.driving.controller;

import com.emazon.msvc_transaction.domain.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.API_SUPPLY_PATH)
public class SupplyController {

    @PostMapping("")
    public ResponseEntity<String> add(){
        String greeting = "Hello warehouse assistant user from transaction microservice.";
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
