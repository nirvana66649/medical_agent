package com.laioffer;


import com.laioffer.assistant.USCAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AIServiceTest {
    @Autowired
    private QwenChatModel qwenChatModel;

//    @Test
//    public void testChat() {
//        //创建AIService
//        USCAssistant assistant = AiServices.create(USCAssistant.class, qwenChatModel);
//        //调用service的接口
//        String answer = assistant.chat("Hello");
//        System.out.println(answer);
//    }
}