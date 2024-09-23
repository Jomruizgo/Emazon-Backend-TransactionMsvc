package com.emazon.msvc_transaction.adapters.driven.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.emazon.msvc_transaction.domain.exceptions.ClaimNotFoundException;
import com.emazon.msvc_transaction.domain.exceptions.InvalidClaimTypeException;
import com.emazon.msvc_transaction.domain.spi.ITokenServicePort;
import com.emazon.msvc_transaction.domain.util.AuthMessages;
import org.springframework.beans.factory.annotation.Value;


public class JavaJwtAdapter implements ITokenServicePort {

    @Value("${security.jwt.secret-key}")
    private String privateKey;

    @Value("${security.jwt.user.generator}")
    private String userGenerator;



    @Override
    public String extractUsername(String token) {
        DecodedJWT decodedToken = this.decodeValidToken(token);
        return decodedToken.getSubject();
    }

    @Override
    public String extractSpecificClaim(String token, String claimName) {
        DecodedJWT decodedToken = this.decodeValidToken(token);
        Claim claim = decodedToken.getClaim(claimName);

        if (claim == null) {
            throw new ClaimNotFoundException(AuthMessages.CLAIM_NOT_FOUND_MESSAGE);
        }

        if (claim.asString() != null) {
            return claim.asString();

        } else if (claim.asInt() != null) {
            return String.valueOf(claim.asInt());

        } else if (claim.asLong() != null) {
            return String.valueOf(claim.asLong());

        } else {
            throw new InvalidClaimTypeException(AuthMessages.INVALID_CLAIM_MESSAGE);
        }
    }

    @Override
    public boolean isValidToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.privateKey);

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(this.userGenerator)
                    .build();

            verifier.verify(token);

            return true;

        } catch (JWTVerificationException exception) {
            return false;
        }
    }



    private DecodedJWT decodeValidToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.privateKey);

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(this.userGenerator)
                    .build();

            return verifier.verify(token);
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException(AuthMessages.INVALID_TOKEN_MESSAGE);
        }
    }
}
