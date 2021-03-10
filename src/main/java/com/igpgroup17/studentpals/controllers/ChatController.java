package com.igpgroup17.studentpals.controllers;

import com.igpgroup17.studentpals.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat/join/{roomId}")
    public ResponseEntity<String> join(@PathVariable(name = "roomId") String roomId, String userId) {
        return ResponseEntity.ok(chatService.joinRoom(roomId, userId));
    }

    @PostMapping("/chat/leave/{roomId}")
    public ResponseEntity<String> leave(@PathVariable(name = "roomId") String roomId, String userId) {
        return ResponseEntity.ok(chatService.leaveRoom(roomId, userId));
    }

    @GetMapping("/chat/helloworld")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok(chatService.helloWorld());
    }
}
