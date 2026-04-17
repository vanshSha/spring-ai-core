package com.spring_ai_advisor.service;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;


@Service
public class MessageChatMemoryAdvisorService {

    private final ChatClient chatClient;
    ChatMemory chatMemory;

    public MessageChatMemoryAdvisorService(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).build();
    }

    public String getMessageChatMemory(String conversationId, String userQuery) {
        return chatClient.prompt().user(userQuery).advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
                .call()
                .content();
    }

    // This is use for in-memory
    public String fetchHistory(String id) {
        var memory = chatMemory.get(id);
        if (memory == null || memory.isEmpty()) {
            return "No history found for: " + id;
        }
        return memory.toString();
    }


}
