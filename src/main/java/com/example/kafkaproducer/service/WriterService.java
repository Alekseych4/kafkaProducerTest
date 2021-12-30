package com.example.kafkaproducer.service;

import com.example.kafkaproducer.model.WriterDto;
import com.example.kafkaproducer.model.WriterResponseDto;

public interface WriterService {
    WriterResponseDto getWriterByNickname(String nickname);
    void createWriter(WriterDto writerDto);
    void deleteWriter(String nickname);
}
