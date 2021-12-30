package com.example.kafkaproducer.exception;

public class DefaultResponseException extends RuntimeException{
    public DefaultResponseException(String msg) {
        super(msg);
    }
}
