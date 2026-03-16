//package com.config;
//
//import org.springframework.ai.anthropic.AnthropicChatModel;
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.openai.OpenAiChatModel;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
////@Configuration
//public class ChatClientConfig {
///*If I want to work different AI models that case
//I will define separate ChatClient beans for each model.*/
//
//    //@Bean  // This is bean of OpenAiChatModel
//    // @Primary
//    public ChatClient openAiChatClient(OpenAiChatModel chatModel) {
//        return ChatClient.create(chatModel);
//    }
//
//    //@Bean
//    //@Qualifier("anthropicChatClient")
//    public ChatClient anthropicChatClient(AnthropicChatModel chatModel) {
//        return ChatClient.create(chatModel);
//    }
//
//}
