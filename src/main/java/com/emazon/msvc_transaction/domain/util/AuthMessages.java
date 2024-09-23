package com.emazon.msvc_transaction.domain.util;

public class AuthMessages {
    private AuthMessages(){throw new IllegalStateException("Utility class");}

    public static final String INVALID_TOKEN_MESSAGE = "Invalid token, not Authorized";
    public static final String INVALID_CLAIM_MESSAGE = "Invalid Claim Type";
    public static final String CLAIM_NOT_FOUND_MESSAGE = "Invalid token, Claim not found";
}
