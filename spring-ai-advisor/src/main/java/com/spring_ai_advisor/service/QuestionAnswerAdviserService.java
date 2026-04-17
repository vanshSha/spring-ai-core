//package com.spring_ai_advisor.service;
//
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.ai.chat.client.ChatClient;
//
//import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
//import org.springframework.ai.chat.memory.ChatMemory;
//import org.springframework.ai.transformer.splitter.TokenTextSplitter;
//import org.springframework.ai.vectorstore.SearchRequest;
//import org.springframework.ai.vectorstore.VectorStore;
//import org.springframework.stereotype.Service;
//
//import org.springframework.ai.document.Document;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class QuestionAnswerAdviserService {
//
//    private final ChatClient chatClient;
//    private final VectorStore vectorStore;
//    //private final ChatMemory chatMemory;
//
//    public String getQuestionAnswer(String conversationId, String userQuery) {
//        log.info("User Question: {}", userQuery);
//        QuestionAnswerAdvisor qaAdvisor = QuestionAnswerAdvisor.builder(vectorStore)
//                .searchRequest(SearchRequest
//                        .builder()
//                        .query(userQuery)
//                        .topK(1)
//                        .similarityThreshold(0.7)
//                        .build())
//                .build();
//
//        String response = chatClient.prompt().user(userQuery)
//                .advisors(qaAdvisor)
//                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
//                .call()
//                .content();
//
//        log.info("LLM Response: {}", response);
//        return response;
//    }
//
//    // I will study later this annotation
//    @PostConstruct // This method run automatically after bean creation and dependencies creations.
//    public void loadDocument() {
//        Document document = new Document("The Sky is RED");
//        List<Document> documents = new TokenTextSplitter().apply(List.of(document));
//        vectorStore.add(documents);
//        log.info("Documents loaded into VectorStore");
//    }
//
//    // This part isn't working
//    public String qaAdvisorHistory(String id) {
//        var result = vectorStore.similaritySearch(SearchRequest.builder().query(id).topK(1).similarityThreshold(0.7).build());
//        log.info("ChatMemory messages for id [{}]: {}", id, result);
//
//        if (result == null || result.isEmpty()) {
//            log.warn("No messages found. Did you chat with id={} first?", id);
//            return "Empty — check logs";
//        }
//        return result.toString();
//    }
//
//}
