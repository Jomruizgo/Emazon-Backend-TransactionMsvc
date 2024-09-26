package com.emazon.msvc_transaction.configuration.temporal;

import com.emazon.msvc_transaction.adapters.driven.data.mongodb.document.SupplyDocument;
import com.emazon.msvc_transaction.adapters.driven.data.mongodb.repository.ISupplyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(ISupplyRepository supplyRepository) {
        return args -> {
            SupplyDocument supply1 = new SupplyDocument();
            supply1.setId("1");
            supply1.setArticleId(1L);
            supply1.setWarehouseAssistantId(2L);
            supply1.setQuantityAdded(50);
            supply1.setDateSupplied(LocalDateTime.now());
            supply1.setDateNextSupply((new SimpleDateFormat("yyyy-MM-dd")).parse("2024-12-15"));
            supply1.setQuantityNextSupply(100);

            SupplyDocument supply2 = new SupplyDocument();
            supply2.setId("2");
            supply2.setArticleId(2L);
            supply2.setWarehouseAssistantId(6L);
            supply2.setQuantityAdded(30);
            supply2.setDateSupplied(LocalDateTime.now());
            supply2.setDateNextSupply((new SimpleDateFormat("yyyy-MM-dd")).parse("2024-12-20"));
            supply2.setQuantityNextSupply(60);

            supplyRepository.save(supply1);
            supplyRepository.save(supply2);
        };
    }
}
