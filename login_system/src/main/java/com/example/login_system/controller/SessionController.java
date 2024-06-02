package com.example.login_system.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SessionController {

    @GetMapping("/session/set")
    public String setSessionValue(HttpServletRequest request, @RequestParam String value) {
        request.getSession().setAttribute("myValue", value);
        return "Value set in session: " + value;
    }

    @GetMapping("/session/get")
    public String getSessionValue(HttpServletRequest request) {
        String value = (String) request.getSession().getAttribute("myValue");
        return value != null ? "Value from session: " + value : "No value in session";
    }
}
