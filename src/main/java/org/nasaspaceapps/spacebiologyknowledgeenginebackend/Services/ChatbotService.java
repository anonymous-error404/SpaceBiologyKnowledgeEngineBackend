package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Services;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Repositories.ChatMemory;
import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Repositories.KnowledgeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    private final ChatMemory chatMemory;
    private final Client client;
    private final KnowledgeRepository knowledgeRepository;

    public ChatbotService(ChatMemory chatMemory,
                          @Value("${google.genai.api-key}") String apiKey, KnowledgeRepository knowledgeRepository) {
        this.chatMemory = chatMemory;
        this.client = Client.builder().apiKey(apiKey).build();
        this.knowledgeRepository = knowledgeRepository;
    }

    public void startSessionWithPaper(String sessionId, int paper_id) {
        String paperContent = knowledgeRepository.findByPaperId(paper_id).toString();
        chatMemory.setSystemPrompt(sessionId, paperContent);
    }

    public String chat(String sessionId, String userMessage) {
        // Save user message
        chatMemory.addMessage(sessionId, "user", userMessage);

        // Build the conversation prompt
        StringBuilder prompt = new StringBuilder();
        prompt.append("SYSTEM PROMPT: \n")
                .append(chatMemory.getSystemPrompt(sessionId))
                .append("\n\n");

        for (String msg : chatMemory.getMessages(sessionId)) {
            prompt.append(msg).append("\n");
        }

        try {
            GenerateContentResponse response = client.models.generateContent(
                    "gemini-2.5-flash",   // latest model
                    prompt.toString(),
                    null                   // optional parameters
            );

            String reply = response.text();

            chatMemory.addMessage(sessionId, "assistant", reply);

            return reply;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error generating response.";
        }
    }

    public void clearMemory(String sessionId) {
        chatMemory.clear(sessionId);
    }
}

