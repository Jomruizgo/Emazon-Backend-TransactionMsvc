package com.emazon.msvc_transaction.adapters.driving.controller;

import com.emazon.msvc_transaction.domain.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.API_SALE_PATH)
public class SaleController {

    @PostMapping("")
    public ResponseEntity<String> sell(){
        String greeting = "Hello client user from transaction microservice.";
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
