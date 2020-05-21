package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserService {

    @Override
    public String getPythonUser() {
        return "python fallback user";
    }

    @Override
    public String getNodeUser(){
        return "node fallback user";
    }

    @Override
    public String getPhpUser() {
        return "php fallback user";
    }

    @Override
    public String getGoUser() {
        return "go fallback user";
    }

    @Override
    public String getRubyUser() {
        return "ruby fallback user";
    }

    @Override
    public String getAspUser() {
        return "asp fallback user";
    }

}
