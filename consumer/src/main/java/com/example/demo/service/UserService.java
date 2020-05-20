package com.example.demo.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="gateway", fallback = UserServiceFallback.class)
public interface UserService {

    @RequestMapping("/py/getUser")
    public String getPythonUser();

    @RequestMapping("/nd/getUser")
    public String getNodeUser();

    @RequestMapping("/php/getUser")
    public String getPhpUser();

    @RequestMapping("/go/getUser")
    public String getGoUser();

    @RequestMapping("/rb/getUser")
    public String getRubyUser();
}
