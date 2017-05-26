package com.lftechnology.sample.service;

import java.util.Map;

import com.lftechnology.sample.model.User;

public interface JwtTokenService {

    String payloadToToken(Map<String, Object> tokenPayLoad);

    Map<String, Object> makePayload(User user, Integer expiryAfterMinutes);

    User decodePayload(String token);

    Map<String, Object> validate(String token);
}
