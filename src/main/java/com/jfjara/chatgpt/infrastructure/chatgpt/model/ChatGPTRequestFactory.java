package com.jfjara.chatgpt.infrastructure.chatgpt.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChatGPTRequestFactory {

    @Value("${chatgpt.model}")
    private String model;

    @Value("${chatgpt.max-tokens}")
    private int maxTokens;

    public ChatGPTRequest create(final String query) {
        final var charGTPMessage = new ChatGPTMessage("user", query);
        final var chatGPTRequest = new ChatGPTRequest(model, charGTPMessage, maxTokens);
        return chatGPTRequest;
    }
}
