package com.laioffer;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
 import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
 @SpringBootTest
 public class LLMTest {
    /**
     * gpt-4o-mini语言模型接入测试
     */
    @Autowired
    private QwenChatModel qwenChatModel;
     @Test
     public void testDashScopeQwen() {
         //向模型提问
         String answer = qwenChatModel.chat("你好");
         //输出结果
         System.out.println(answer);
     }

 }