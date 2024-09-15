package com.jfjara.chatgpt.infrastructure.chatgpt.repository;

import com.jfjara.chatgpt.domain.chat.repository.ChatRepository;
import com.jfjara.chatgpt.domain.chat.exception.ChatException;
import com.jfjara.chatgpt.infrastructure.chatgpt.client.ChatGPTClient;
import com.jfjara.chatgpt.infrastructure.chatgpt.model.ChatGPTRequestFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ChatGPTRepository implements ChatRepository {

    private final ChatGPTClient chatGPTClient;

    private final ChatGPTRequestFactory chatGPTRequestFactory;

    @Override
    public String chat(final String query) throws ChatException {
        final var chatGPTRequest = this.chatGPTRequestFactory.create(query);
        return this.chatGPTClient.get(chatGPTRequest);
    }
}
