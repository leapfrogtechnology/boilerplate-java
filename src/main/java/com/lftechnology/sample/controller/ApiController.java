package com.lftechnology.sample.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lftechnology.sample.exception.ApiException;
import com.lftechnology.sample.model.User;
import com.lftechnology.sample.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public HashMap<String, Object> userinfo(@PathVariable Long id) throws ApiException {
        HashMap<String, Object> response = new HashMap<>();
        User userInfo = userService.findUserById(id);
        if (userInfo != null) {
            response.put("data", userInfo);
            response.put("statusCode", HttpStatus.OK.value());
            return response;
        } else {
            throw new ApiException("Person not exist", HttpStatus.NOT_FOUND);
        }
    }
}
