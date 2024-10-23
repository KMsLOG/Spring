package com.ssafy.hw.controller;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    private final OllamaChatModel chatModel;

    @Autowired
    public ChatController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
        logger.info("Ollama chat model initialized. GPU usage will be logged if available.");
    }

    @GetMapping("/ai/generate")
    @Cacheable(value = "aiResponses", key = "#message")
    public Map<String, String> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        logger.info("Generating response for message: {}", message);
        try {
            long startTime = System.currentTimeMillis();
            String response = chatModel.call("Respond in Markdown format. " + message);
            long endTime = System.currentTimeMillis();
            logger.info("Response generated in {} ms. GPU usage should be reflected in Ollama logs.", (endTime - startTime));
            return Map.of("generation", response);
        } catch (Exception e) {
            logger.error("Error generating response", e);
            return Map.of("error", "Failed to generate response: " + e.getMessage());
        }
    }

    @GetMapping("/ai/generateAsync")
    @Async
    public CompletableFuture<Map<String, String>> generateAsync(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        logger.info("Generating async response for message: {}", message);
        return CompletableFuture.supplyAsync(() -> {
            try {
                long startTime = System.currentTimeMillis();
                String response = chatModel.call("Respond in Markdown format. " + message);
                long endTime = System.currentTimeMillis();
                logger.info("Async response generated in {} ms. GPU usage should be reflected in Ollama logs.", (endTime - startTime));
                return Map.of("generation", response);
            } catch (Exception e) {
                logger.error("Error generating async response", e);
                return Map.of("error", "Failed to generate response: " + e.getMessage());
            }
        });
    }

    @GetMapping("/chatbot")
    public String chatbotPage() {
        return "chatbot";
    }
}