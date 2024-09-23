package com.emazon.msvc_transaction.domain.util;

public enum JwtClaim {
    USER_ID("userId"),
    AUTHORITIES("authorities");

    private final String claimName;

    JwtClaim(String claimName) {
        this.claimName = claimName;
    }

    public String getClaimName() {
        return claimName;
    }
}
