package com.jfjara.chatgpt.domain.chat.repository;

import com.jfjara.chatgpt.domain.chat.exception.ChatException;

public interface ChatRepository {

    String chat(final String query) throws ChatException;
}
