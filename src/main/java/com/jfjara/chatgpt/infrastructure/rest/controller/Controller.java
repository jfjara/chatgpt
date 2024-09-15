package com.jfjara.chatgpt.infrastructure.rest.controller;

import com.jfjara.chatgpt.domain.chat.exception.ChatException;
import com.jfjara.chatgpt.infrastructure.chatgpt.repository.ChatGPTRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {

    private final ChatGPTRepository chatGPTRepository;

    @GetMapping(path = "v1/chat")
    public ResponseEntity<String> chat(@RequestParam(name = "query") final String query) {
        try {
            final var result = chatGPTRepository.chat(query);
            return ResponseEntity.ok(result);
        } catch (final ChatException chatException) {
            throw chatException.toRuntime();
        }
    }

}
