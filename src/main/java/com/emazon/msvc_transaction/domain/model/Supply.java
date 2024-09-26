package com.emazon.msvc_transaction.domain.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Supply {
    private String id;
    private Long articleId;
    private Long warehouseAssistantId;
    private int quantityAdded;
    private LocalDateTime dateSupplied;
    private Date dateNextSupply;
    private int quantityNextSupply;

    public  Supply(){}

    public Supply(String id, Long articleId, Long warehouseAssistantId, int quantityAdded, LocalDateTime dateSupplied, Date dateNextSupply, int quantityNextSupply) {
        this.id = id;
        this.articleId = articleId;
        this.warehouseAssistantId = warehouseAssistantId;
        this.quantityAdded = quantityAdded;
        this.dateSupplied = dateSupplied;
        this.dateNextSupply = dateNextSupply;
        this.quantityNextSupply = quantityNextSupply;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getWarehouseAssistantId() {
        return warehouseAssistantId;
    }

    public void setWarehouseAssistantId(Long warehouseAssistantId) {
        this.warehouseAssistantId = warehouseAssistantId;
    }

    public int getQuantityAdded() {
        return quantityAdded;
    }

    public void setQuantityAdded(int quantityAdded) {
        this.quantityAdded = quantityAdded;
    }

    public LocalDateTime getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDateTime dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public Date getDateNextSupply() {
        return dateNextSupply;
    }

    public void setDateNextSupply(Date dateNextSupply) {
        this.dateNextSupply = dateNextSupply;
    }

    public int getQuantityNextSupply() {
        return quantityNextSupply;
    }

    public void setQuantityNextSupply(int quantityNextSupply) {
        this.quantityNextSupply = quantityNextSupply;
    }
}
