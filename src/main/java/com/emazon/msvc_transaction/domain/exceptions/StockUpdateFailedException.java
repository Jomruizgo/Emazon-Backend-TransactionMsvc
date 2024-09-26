package com.emazon.msvc_transaction.domain.exceptions;

public class StockUpdateFailedException extends RuntimeException{
    public StockUpdateFailedException(String message){super(message);}
}
