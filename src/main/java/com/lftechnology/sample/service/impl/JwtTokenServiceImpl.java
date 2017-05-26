package com.lftechnology.sample.service.impl;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.lftechnology.sample.model.User;
import com.lftechnology.sample.service.JwtTokenService;

public class JwtTokenServiceImpl implements JwtTokenService {

    private static final String ISS = "iss";
    private static final String SUB = "sub";
    private static final String AUD = "aud";
    private static final String EXP = "exp";
    private static final String IAT = "iat";
    private static final String AUDIENCE = "1";
    private static final String APP_SECRET_KEY = "appSecret";
    private static final String ISSUER = "Leapfrog Technology";

    @Override
    public String payloadToToken(Map<String, Object> tokenPayLoad) {
        return new JWTSigner(APP_SECRET_KEY).sign(tokenPayLoad);
    }

    @Override
    public Map<String, Object> makePayload(User user, Integer expiryAfterMinutes) {
        LocalDateTime now = LocalDateTime.now();
        return new HashMap<String, Object>() {
            {
                put(ISS, ISSUER);
                put(SUB, user.toString());
                put(AUD, AUDIENCE);
                put(EXP, now.plusMinutes(expiryAfterMinutes).atZone(ZoneId.systemDefault()).toEpochSecond());
                put(IAT, now.atZone(ZoneId.systemDefault()).toEpochSecond());
            }
        };

    }

    @Override
    public User decodePayload(String token) {
        Map<String, Object> map = validate(token);
        User user = (User) map.get(SUB);
        return user;
    }

    @Override
    public Map<String, Object> validate(String token) {
        try {
            Map<String, Object> decodedPayload = new JWTVerifier(APP_SECRET_KEY, AUDIENCE).verify(token);

            Long exp = Long.valueOf(decodedPayload.get(EXP).toString());
            Instant instant = Instant.ofEpochMilli(exp);
            LocalDateTime expiry = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

            if (expiry.isAfter(LocalDateTime.now())) {
                // TODO throw UnAuthorized exception
                return new HashMap<>();
            }

            return decodedPayload;
        } catch (InvalidKeyException | NoSuchAlgorithmException | IllegalStateException | SignatureException | IOException
                | JWTVerifyException e) {
            // TODO throw UnAuthorized exception
            return new HashMap<>();
        }
    }

}
