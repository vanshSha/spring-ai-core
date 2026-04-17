package com.spring_ai_advisor.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.StructuredOutputValidationAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public ChatClient chatClient(ChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }

    //@Bean
    public StructuredOutputValidationAdvisor structuredOutputValidationAdvisor() {
        return StructuredOutputValidationAdvisor.builder().build();
    }
}
