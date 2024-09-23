package com.emazon.msvc_transaction.adapters.driven.security.context;

import com.emazon.msvc_transaction.domain.spi.IAuthenticationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationContextAdapter  implements IAuthenticationContext {
    @Override
    public Long getAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Long) authentication.getPrincipal();
    }
}
