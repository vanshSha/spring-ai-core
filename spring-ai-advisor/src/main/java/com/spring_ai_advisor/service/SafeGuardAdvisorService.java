package com.spring_ai_advisor.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SafeGuardAdvisorService {

    private final ChatClient chatClient;
    //private final VectorStore vectorStore;
    private final ChatMemory chatMemory;

    public String getSafeGuardMessage(String query){
        List<String> word = List.of("Hello");
        SafeGuardAdvisor sgAdvisor = new SafeGuardAdvisor(word);

        String result = chatClient.prompt()
                .user(query)
                .advisors(
                        sgAdvisor,
                        MessageChatMemoryAdvisor.builder(chatMemory).build())
                .call()
                .content();
        return result;
    }



}
