package com.emazon.msvc_transaction.adapters.driven.data.feign.client;

import com.emazon.msvc_transaction.domain.model.StockRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-service", url = "${stock.service.url}")
public interface IStockFeignClient {

    @PostMapping("/api/article/supply")
    ResponseEntity<Boolean> incrementStock(@RequestBody StockRequest stockRequest);
}
