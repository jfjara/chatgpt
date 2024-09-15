package com.jfjara.chatgpt.domain.chat.exception;

import lombok.Getter;

@Getter
public class ChatException extends Exception{

    public ChatException(final String message) {
        super(message);
    }

    public ChatRuntimeException toRuntime() {
        return new ChatRuntimeException(this.getMessage());
    }

    public class ChatRuntimeException extends RuntimeException {

        public ChatRuntimeException(final String message) {
            super(message);
        }
    }
}
