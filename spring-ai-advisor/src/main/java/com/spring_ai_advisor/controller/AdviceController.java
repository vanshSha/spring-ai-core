package com.spring_ai_advisor.controller;

import com.spring_ai_advisor.service.ChatMemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdviceController {

    @Autowired
    private ChatMemoryService chatMemoryService;


    @GetMapping("/response/{id}")
    public String getResponse(@PathVariable String id, @RequestParam String query){
        return chatMemoryService.getChatClient(id, query);
    }

    @GetMapping("/history/{id}")
    public String getHistory(@PathVariable String id){
        return chatMemoryService.fetchHistoryFVectorStore(id);
    }

}
