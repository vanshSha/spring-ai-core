package com.spring_ai_advisor.controller;
import com.spring_ai_advisor.service.PromptChatMemoryAdvisorService;
//import com.spring_ai_advisor.service.QuestionAnswerAdviserService;
import com.spring_ai_advisor.service.SafeGuardAdvisorService;
import com.spring_ai_advisor.service.recursiveadvisor.BookSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdviceController {

//    @Autowired
//    private VectorChatMemoryAdvisorService chatMemoryService;

    @Autowired
    private PromptChatMemoryAdvisorService promptService;

//    @GetMapping("/response/{id}")
//    public String getResponse(@PathVariable String id, @RequestParam String query){
//        return chatMemoryService.getChatClient(id, query);
//    }

//    @GetMapping("/history/{id}")
//    public String getHistory(@PathVariable String id){
//        return chatMemoryService.fetchHistoryFVectorStore(id);
//    }

    // Prompt Chat Memory Advisor
    @GetMapping("/promptChatMemoryAdvisor/{id}")
    public String getPromptChatMemoryAdvisor(@PathVariable String id, @RequestParam String query) {
        return promptService.getPromptResponse(id, query);
    }

//    @Autowired
//    private QuestionAnswerAdviserService qaAdvisorService;

    // QuestionAnswerAdvisor
//    @GetMapping("/questionAnswerAdvisor/{id}")
//    public String getQuestionAnswerAdvisor(@PathVariable String id, @RequestParam String query){
//            return qaAdvisorService.getQuestionAnswer(id, query);
//    }

//    @GetMapping("questionAnswerAdvisorHistory/{id}")
//    public String getQAAdvisorHistory(@PathVariable String id){
//        return qaAdvisorService.qaAdvisorHistory(id);
//    }

    @Autowired
    private SafeGuardAdvisorService sfAdvisorService;

    // SafeGuardAdvisor
    @GetMapping("safeGuardAdvisor")
    public String getSafeGuardAdvisor(@RequestParam String query){
        return sfAdvisorService.getSafeGuardMessage(query);
    }

    // Recursive Advisor
    @Autowired
    private BookSummaryService bookSummaryService;

    // Summarize '1984' by George Orwell with its main themes
    @GetMapping("/fetchBook")
    public String getBookSummary(@RequestParam String query){
        return bookSummaryService.getBookSummary(query);
    }
}
