package com.emazon.msvc_transaction.adapters.driven.data.mongodb.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "supplies")
public class SupplyDocument {
    @Id
    private String id;

    private Long articleId;
    private Long warehouseAssistantId;
    private int quantityAdded;
    private LocalDateTime dateSupplied;
    private Date dateNextSupply;
    private int quantityNextSupply;
}
