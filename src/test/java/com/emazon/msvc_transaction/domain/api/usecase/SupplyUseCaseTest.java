package com.emazon.msvc_transaction.domain.api.usecase;

import com.emazon.msvc_transaction.domain.exceptions.StockUpdateFailedException;
import com.emazon.msvc_transaction.domain.model.StockRequest;
import com.emazon.msvc_transaction.domain.model.Supply;
import com.emazon.msvc_transaction.domain.spi.IAuthenticationContext;
import com.emazon.msvc_transaction.domain.spi.IStockServicePort;
import com.emazon.msvc_transaction.domain.spi.ISupplyPersistencePort;
import com.emazon.msvc_transaction.domain.util.TestConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SupplyUseCaseTest {

    @Mock
    private IAuthenticationContext authenticationContext;

    @Mock
    private IStockServicePort stockServicePort;

    @Mock
    private ISupplyPersistencePort supplyPersistencePort;

    @InjectMocks
    private SupplyUseCase supplyUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addSupply_shouldUpdateStockAndSaveSupply_whenStockUpdateIsSuccessful() {
        // Arrange
        Long articleId = 1L;
        int quantityAdded = 10;
        Long warehouseAssistantId = 2L;

        Supply supply = new Supply();
        supply.setArticleId(articleId);
        supply.setQuantityAdded(quantityAdded);

        when(authenticationContext.getAuthenticatedUserId()).thenReturn(warehouseAssistantId);
        when(stockServicePort.stockIncrease(any(StockRequest.class))).thenReturn(true);

        // Act
        supplyUseCase.addSupply(supply);

        // Assert
        assertEquals(warehouseAssistantId, supply.getWarehouseAssistantId());
        assertNotNull(supply.getDateSupplied());
        verify(stockServicePort).stockIncrease(any(StockRequest.class));
        verify(supplyPersistencePort).saveSupply(supply);
    }

    @Test
    void addSupply_shouldThrowException_whenStockUpdateFails() {
        // Arrange
        Long articleId = 1L;
        int quantityAdded = 10;

        Supply supply = new Supply();
        supply.setArticleId(articleId);
        supply.setQuantityAdded(quantityAdded);

        when(authenticationContext.getAuthenticatedUserId()).thenReturn(2L);
        when(stockServicePort.stockIncrease(any(StockRequest.class))).thenReturn(false);

        // Act & Assert
        StockUpdateFailedException exception = assertThrows(StockUpdateFailedException.class, () -> {
            supplyUseCase.addSupply(supply);
        });

        assertEquals(TestConstants.STOCK_UPDATE_FAILED_MESSAGE, exception.getMessage());
        verify(supplyPersistencePort, never()).saveSupply(supply);
    }

}