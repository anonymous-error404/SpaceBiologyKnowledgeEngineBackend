package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Repositories;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class ChatMemory {

    // sessionId -> conversation
    private final Map<String, List<String>> memory = new HashMap<>();

    // sessionId -> system prompt (research paper)
    private final Map<String, String> systemPrompts = new HashMap<>();

    private static final int MAX_MESSAGES = 20; // limit per session

    public void setSystemPrompt(String sessionId, String prompt) {
        systemPrompts.put(sessionId, prompt);
        memory.putIfAbsent(sessionId, new ArrayList<>());
    }

    public String getSystemPrompt(String sessionId) {
        return systemPrompts.getOrDefault(sessionId, "");
    }

    public void addMessage(String sessionId, String role, String content) {
        List<String> messages = memory.computeIfAbsent(sessionId, k -> new ArrayList<>());
        messages.add(role + ": " + content);

        // Trim oldest messages if exceeding MAX_MESSAGES
        if (messages.size() > MAX_MESSAGES) {
            messages.subList(0, messages.size() - MAX_MESSAGES).clear();
        }
    }

    public List<String> getMessages(String sessionId) {
        return memory.getOrDefault(sessionId, new ArrayList<>());
    }

    public void clear(String sessionId) {
        memory.remove(sessionId);
        systemPrompts.remove(sessionId);
    }
}
