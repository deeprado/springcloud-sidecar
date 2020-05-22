package com.example.demo;

import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class JavaController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/java-user")
    public String JavaUser() {
        return "{'username': 'java', 'password': 'java'}";
    }

    @RequestMapping("/python-user")
    public String PythonUser() {
        return restTemplate.getForEntity("http://py-sidecar/getUser", String.class).getBody();
    }

    @RequestMapping("/node-user")
    public String NodeUser() {
        return restTemplate.getForEntity("http://nd-sidecar/getUser", String.class).getBody();
    }

    @RequestMapping("/php-user")
    public String PhpUser() {
        return restTemplate.getForEntity("http://php-sidecar/getUser", String.class).getBody();
    }

    @RequestMapping("/go-user")
    public String GoUser() {
        return restTemplate.getForEntity("http://go-sidecar/getUser", String.class).getBody();
    }

    @RequestMapping("/ruby-user")
    public String RubyUser() {
        return restTemplate.getForEntity("http://rb-sidecar/getUser", String.class).getBody();
    }

    @RequestMapping("/asp-user")
    public String AspUser() {
        return restTemplate.getForEntity("http://asp-sidecar/getUser", String.class).getBody();
    }

    @RequestMapping("/test-py-user")
    public String TestPyUser() {
        return userService.getPythonUser();
    }

    @RequestMapping("/test-php-user")
    public String TestPHPUser() {
        return userService.getPhpUser();
    }

    @RequestMapping("/test-go-user")
    public String TestGoUser() {
        return userService.getGoUser();
    }

    @RequestMapping("/test-node-user")
    public String TestNodeUser() {
        return userService.getNodeUser();
    }

    @RequestMapping("/test-ruby-user")
    public String TestRubyUser() {
        return userService.getRubyUser();
    }

    @RequestMapping("/test-asp-user")
    public String TestAspUser() {
        return userService.getAspUser();
    }
}
