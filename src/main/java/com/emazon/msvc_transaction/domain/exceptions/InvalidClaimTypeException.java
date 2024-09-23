package com.emazon.msvc_transaction.domain.exceptions;

public class InvalidClaimTypeException extends RuntimeException {
    public InvalidClaimTypeException(String message) { super(message); }
}