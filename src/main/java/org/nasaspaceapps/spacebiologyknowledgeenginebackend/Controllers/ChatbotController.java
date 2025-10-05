package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Controllers;

import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Services.ChatbotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/chat")
public class ChatbotController {

    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @GetMapping("/start/{paper_id}")
    public ResponseEntity<Map<String, String>> startSession(@PathVariable int paper_id) {
        System.out.println("Paper ID: " + paper_id);
        String sessionId = UUID.randomUUID().toString();  // generate unique session ID
        System.out.println("sessionId: " + sessionId);
        chatbotService.startSessionWithPaper(sessionId, paper_id);

        Map<String, String> response = new HashMap<>();
        response.put("sessionId", sessionId);
        response.put("message", "Session started with paper content.");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{sessionId}")
    public ResponseEntity<Map<String, String>> chat(@PathVariable String sessionId, @RequestBody String message) {
        String reply = chatbotService.chat(sessionId, message);

        Map<String, String> response = new HashMap<>();
        response.put("sessionId", sessionId);
        response.put("reply", reply);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/clearmemory/{sessionId}")
    public ResponseEntity<Map<String, String>> clearMemory(@PathVariable String sessionId) {
        chatbotService.clearMemory(sessionId);
        Map<String, String> response = new HashMap<>();
        response.put("sessionId", sessionId);
        return ResponseEntity.ok(response);
    }
}

