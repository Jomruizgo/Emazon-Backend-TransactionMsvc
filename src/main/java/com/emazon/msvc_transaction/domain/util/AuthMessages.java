package com.emazon.msvc_transaction.domain.util;

public class AuthMessages {
    private AuthMessages(){throw new IllegalStateException("Utility class");}

    public static final String INVALID_TOKEN_MESSAGE = "Token invalid, not Authorized";
}
