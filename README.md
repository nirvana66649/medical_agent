DeepMed Intelligent Consultation System
(Built using the QWEN large language model and a local knowledge base with RAG technology)

Developed with LangChain4j, the system constructs an intelligent medical consultation agent integrated with QWEN's large language model, supporting backend tool calls such as appointment booking and modification.

Utilizes Redis vector database and Retrieval-Augmented Generation (RAG) to provide accurate, document-based medical Q&A responses.

Implements a custom ChatMemoryStore interface to support multi-turn conversation memory and recovery using MongoDB.


Key Points:
2. how to create our vector database
3. how to upload our local knowledge base to the vector database


using langchian4j with springboot can help you easily build this project 
Springboot's automatic injection device reduces my code writing



to set up a vector database, we need to read the official document from langchain4j(https://docs.langchain4j.dev/integrations/embedding-stores/redis/)
here i use redis, as it can not only be deployed on localhost also we don't need to pay for it

1. the first step, we need to download the redis stack, which is the key point to realize a vector database based on Redis, here i use docker to pull the image--> docker run -p 6379:6379 redis/redis-stack-server:latest
2. once we pull this image to our localhost, we need to start it
3. then we need to write a config file to set up this vector database
4. once we finish all the previous steps, we can now upload the local files to the database(we just need to upload it once, so i write it in the test folder)
5. finally, create a content retriver and everything will be done!!!
