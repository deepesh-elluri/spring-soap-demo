package com.example.soap.service;

import com.example.soap.repo.UserRepository;
import com.example.soap.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserService {
    private static final String NAMESPACE_URI = "http://www.soap.example.com/user";

    @Autowired
    private UserRepository repo;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "User")
    @ResponsePayload
    public User getUserDetails(@RequestPayload User user) {
        return repo.getUserById(user.getId());
    }
    
}
