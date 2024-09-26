package com.emazon.msvc_transaction.domain.model;

public class StockRequest {
    private Long articleId;
    private int quantity;

    public StockRequest() {}

    public StockRequest(Long articleId, int quantity) {
        this.articleId = articleId;
        this.quantity = quantity;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
