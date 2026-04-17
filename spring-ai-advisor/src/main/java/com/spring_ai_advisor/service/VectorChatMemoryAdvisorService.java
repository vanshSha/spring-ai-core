package com.spring_ai_advisor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

//@Service
//@Slf4j
public class VectorChatMemoryAdvisorService {

//    private final ChatClient chatClient;
//    private final ChatMemory chatMemory;
    // @Autowired
    //private final VectorStore vectorStore;

    //VectorStore vectorStore
//    public ChatMemoryService(ChatClient.Builder chatClientBuilder, VectorStore vectorStore, ChatMemory chatMemory) {
//        this.chatMemory = chatMemory;
//        this.chatClient = chatClientBuilder
//                .defaultAdvisors(VectorStoreChatMemoryAdvisor.builder(vectorStore).build()).build();
//    }

//    public String getVectorMessage(String conversationId, String userQuery){
//        return chatClient.prompt().user(userQuery)
//                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
//                .call()
//                .content();
//    }

    // This method also return history of Vector store
//    public String fetchHistoryFVectorStore(String id) {
//        var results = vectorStore.similaritySearch(SearchRequest.builder().query("conversationId" + id).topK(10)
//                .filterExpression("conversationId == '" + id + "'")
//                .build());
//        if (results == null || results.isEmpty()) {
//            return "No history found for: " + id;
//        }
//        return results.toString();
//    }
}
