package com.igpgroup17.studentpals.services.impl;

import com.igpgroup17.studentpals.chat.ChatRoomActor;
import com.igpgroup17.studentpals.services.ChatService;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    @Override
    public String joinRoom(String roomId, String userId) {
        return null;
    }

    @Override
    public String leaveRoom(String roomId, String userId) {
        return null;
    }

    @Override
    public String helloWorld() {
        return new ChatRoomActor().helloWorld();
    }
}
