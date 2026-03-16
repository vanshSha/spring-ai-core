package com.config;

//import groovyjarjarpicocli.CommandLine;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

//@Configuration
public class ChatClientExample {
    // This is use for Multiple AI models

    //@Bean
//    CommandLineRunner cli(@Qualifier("openAiChatClient")ChatClient openAiChatClient,
//                          @Qualifier("anthropicChatClient")ChatClient anthropicChatClient){
//        return args -> {
//            Scanner scanner = new Scanner(System.in);
//            ChatClient chat;
//
//            // Model Section
//            System.out.println("\nSelect your AI model:");
//            System.out.println("1. OpenAI");
//            System.out.println("2. Anthropic");
//
//            String choice = scanner.nextLine().trim();
//
//            if(choice.equals("1")){
//                chat = openAiChatClient;
//                System.out.println("Using Open AI model");
//            }else{
//                chat = anthropicChatClient;
//                System.out.println("Using Anthropic model");
//            }
//
//            //
//            System.out.println("\nEnter your question: ");
//            String input = scanner.nextLine();
//            String response = chat.prompt(input).call().content();
//            System.out.println("ASSISTANT:" + response);
//
//            scanner.close();
//        };
//    }
}
