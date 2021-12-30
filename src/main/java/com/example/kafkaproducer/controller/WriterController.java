package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.model.WriterDto;
import com.example.kafkaproducer.model.WriterResponseDto;
import com.example.kafkaproducer.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/writer")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WriterController {

    private final WriterService writerService;

    @GetMapping("/{nickname}")
    public WriterResponseDto getWriterByNickname(@PathVariable("nickname") String nickname) {
        return writerService.getWriterByNickname(nickname);
    }

    @PostMapping("/create")
    public void createWriter(@RequestBody WriterDto writerDto) {
        writerService.createWriter(writerDto);
    }

    @DeleteMapping("/{nickname}")
    public void deleteWriter(@PathVariable("nickname") String nickname) {
        writerService.deleteWriter(nickname);
    }
}
