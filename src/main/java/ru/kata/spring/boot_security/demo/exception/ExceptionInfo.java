package ru.kata.spring.boot_security.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class ExceptionInfo {

    private String info;

    public ExceptionInfo() {
    }

    public ExceptionInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
