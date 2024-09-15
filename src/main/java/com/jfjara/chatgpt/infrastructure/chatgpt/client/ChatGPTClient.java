package com.jfjara.chatgpt.infrastructure.chatgpt.client;

import com.jfjara.chatgpt.domain.chat.exception.ChatException;
import com.jfjara.chatgpt.infrastructure.chatgpt.model.ChatGPTRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class ChatGPTClient {

    private static final String AUTH_BEARER_TEMPLATE = "Bearer %s";

    @Value("${chatgpt.url}")
    private String url;

    @Value("${chatgpt.api-key}")
    private String apiKey;

    public String get(final ChatGPTRequest request) throws ChatException {
        final var restTemplate = new RestTemplate();
        final var headers = this.createHeaders();
        final var httpEntity = new HttpEntity<Object>(request, headers);
        try {
            final var response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
            return response.getBody();
        } catch (final Exception exception) {
            throw new ChatException(exception.getMessage());
        }
    }

    private HttpHeaders createHeaders() {
        final var headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", String.format(AUTH_BEARER_TEMPLATE, this.apiKey));
        return headers;
    }

}
