package com.emazon.msvc_transaction.domain.util;


public final class TestConstants {
    private TestConstants() {
        throw new IllegalStateException("Utility class");
    }

    //Controllers Path
    public static final String API_SUPPLY_PATH = "api/supply";
    public static final String API_SALE_PATH = "api/sale";

    public static final String ADMIN_ROLE = "ADMINISTRATOR";

    public static final String SUPPLY_ERROR_MESSAGE = "Error occurred while adding supplies, transaction rollback.";

    public static final String STOCK_UPDATE_FAILED_MESSAGE = "Stock update failed";
}
