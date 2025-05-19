package com.laioffer.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT,
        streamingChatModel = "qwenStreamingChatModel",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "appointmentTools",
        contentRetriever = "contentRetriever")
public interface USCAssistant {
    //定义一个接口，用于定义ai的行为
    //这里的接口是langchain4j提供的，用于定义ai的行为，将userMessage作为参数，返回ai的回复
    //实现记忆力，llm接入，工具调用就是智能体了
    @SystemMessage(fromResource = "prompts.txt")//系统消息提示词
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
