package com.lftechnology.sample.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lftechnology.sample.exception.ApiException;

@RestController
@RequestMapping("/auth")
public class Auth {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public HashMap<String, Object> authenticate() throws ApiException {
        return new HashMap<String, Object>() {
            {
                put("accessToken", "asdfasdf");
            }
        };
    }

}
