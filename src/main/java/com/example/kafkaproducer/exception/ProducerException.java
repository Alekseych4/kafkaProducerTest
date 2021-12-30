package com.example.kafkaproducer.exception;

public class ProducerException extends RuntimeException{
    public ProducerException(String msg) {
        super(msg);
    }
}
