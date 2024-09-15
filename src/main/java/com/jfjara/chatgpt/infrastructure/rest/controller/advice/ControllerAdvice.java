package com.jfjara.chatgpt.infrastructure.rest.controller.advice;

import com.jfjara.chatgpt.domain.chat.exception.ChatException;
import com.jfjara.chatgpt.infrastructure.rest.model.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ChatException.ChatRuntimeException.class)
    public ResponseEntity<ErrorDTO> handleChatException(final ChatException.ChatRuntimeException exception) {
        return ResponseEntity.ok(new ErrorDTO(exception.getMessage()));
    }

}
