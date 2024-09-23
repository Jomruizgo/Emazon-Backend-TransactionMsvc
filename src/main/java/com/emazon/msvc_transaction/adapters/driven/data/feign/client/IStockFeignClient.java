package com.emazon.msvc_transaction.adapters.driven.data.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "stock-service", url = "${stock.service.url}")
public interface IStockFeignClient {

    @PutMapping("/api/article/increment/{articleId}")
    void incrementStock(@PathVariable("articleId") Long articleId, @RequestParam("quantity") int quantity);
}
