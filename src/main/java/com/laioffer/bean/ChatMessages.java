package com.laioffer.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("chat_messages")
//用于标识一个类是一个 MongoDB 文档，指定了文档的集合名称为 "chat_messages"，用于存储聊天消息相关的数据。
public class ChatMessages {
    //唯一标识，映射到 MongoDB 文档的 _id 字段
    @Id
    private ObjectId messageId;
    //private Long messageId;
    private String memoryId;

    private String content; //存储当前聊天记录列表的json字符串，存储客户端和ai的交互信息
}