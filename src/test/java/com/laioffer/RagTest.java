package com.laioffer;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RagTest {
    @Autowired
    private EmbeddingStore<TextSegment> embeddingStore;
    @Autowired
    private EmbeddingModel embeddingModel;
    @Test
    public void testUploader() {
        //将文本文件上传到向量数据库
        Document document1 = FileSystemDocumentLoader.loadDocument("D:/Download/knowledge/knowledge/医院信息.md");
        Document document2 = FileSystemDocumentLoader.loadDocument("D:/Download/knowledge/knowledge/科室信息.md");
        Document document3 = FileSystemDocumentLoader.loadDocument("D:/Download/knowledge/knowledge/神经内科.md");
        List<Document> documents = Arrays.asList(document1, document2, document3);
        EmbeddingStoreIngestor
                .builder()
                .embeddingStore(embeddingStore)
                .embeddingModel(embeddingModel)
                .build()
                .ingest(documents);

    }
}
