package com.jfjara.chatgpt.infrastructure.chatgpt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChatGPTRequest(String model, ChatGPTMessage message, @JsonProperty("max_tokens") int maxTokens) {

}
