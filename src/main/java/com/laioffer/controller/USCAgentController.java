package com.laioffer.controller;

import com.laioffer.assistant.USCAssistant;
import com.laioffer.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Tag(name = "USCAgent")
@RestController
@RequestMapping("/uscagent")
public class USCAgentController {
    @Autowired
    private USCAssistant troyAgent;
    @Operation(summary = "对话")
    @PostMapping("/chat")
    public Flux<String> chat(@RequestBody ChatForm chatForm)  {
        return troyAgent.chat(chatForm.getMemoryId(), chatForm.getMessage());
    }
}

