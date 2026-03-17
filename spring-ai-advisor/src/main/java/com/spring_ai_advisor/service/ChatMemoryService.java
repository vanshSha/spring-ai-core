package com.spring_ai_advisor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.VectorStoreChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class ChatMemoryService {

    private final ChatClient chatClient;
    private final ChatMemory chatMemory;

    @Autowired
    private final VectorStore vectorStore;


    public ChatMemoryService(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory, VectorStore vectorStore) {
        this.chatClient = chatClientBuilder
                  // This is MessageChatMemoryAdvisor
                 // .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build()).build();
                // This is VectorStoreChatMemoryAdvisor
                .defaultAdvisors(VectorStoreChatMemoryAdvisor.builder(vectorStore).build()).build();
        this.chatMemory = chatMemory;
        this.vectorStore = vectorStore;
    }

    public String getChatClient(String conversationId, String userQuery){
        return chatClient.prompt()
                .system("I am MAC for your assistance")
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
                .user(userQuery)
                .call()
                .content();
    }

    // This is use for in-memory
    public String fetchHistory(String id){
        var memory = chatMemory.get(id);
        if(memory == null || memory.isEmpty()){
            return "No history found for: " + id;
        }
        return memory.toString();
    }

    // This method also return history of Vector store
    public String fetchHistoryFVectorStore(String id){
    var results = vectorStore.similaritySearch(SearchRequest.builder().query("conversationId" + id).topK(10)
                .filterExpression("conversationId == '" + id + "'")
                .build());
        if (results == null || results.isEmpty()) {
            return "No history found for: " + id;
        }
        return results.toString();
    }
}
