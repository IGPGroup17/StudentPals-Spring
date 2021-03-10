package com.igpgroup17.studentpals.chat;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class ChatRoomActor extends AbstractBehavior<ChatRoomActor.MessageType> {

    interface MessageType {
        String sender();
    }

    public static class Join implements MessageType {

        private final String sender;

        public Join(String sender) {
            this.sender = sender;
        }

        public String sender() {
            return sender;
        }
    }

    public static class Leave implements MessageType {

        private final String sender;

        public Leave(String sender) {
            this.sender = sender;
        }

        public String sender() {
            return sender;
        }
    }

    public static class MessageSend implements MessageType {

        private final String sender;

        public final String message;

        public MessageSend(String sender, String message) {
            this.sender = sender;
            this.message = message;
        }

        public String sender() {
            return sender;
        }
    }

    public static class MessageReceive implements MessageType {

        private final String sender;

        public final String message;

        public MessageReceive(String sender, String message) {
            this.sender = sender;
            this.message = message;
        }

        public String sender() {
            return sender;
        }
    }

    private ChatRoomActor(ActorContext<MessageType> context) {
        super(context);
    }

    public static Behavior<MessageType> create() {
        return Behaviors.setup(ChatRoomActor::new);
    }

    @Override
    public Receive<MessageType> createReceive() {
        return newReceiveBuilder()
                .onMessage(Join.class, this::onJoin)
                .onMessage(Leave.class, this::onLeave)
                .onMessage(MessageSend.class, this::onSend)
                .onMessage(MessageReceive.class, this::onReceive)
                .build();
    }

    private Behavior<MessageType> onJoin(Join join) {
        return this;
    }

    private Behavior<MessageType> onLeave(Leave leave) {
        return this;
    }

    private Behavior<MessageType> onSend(MessageSend message) {
        return this;
    }

    private Behavior<MessageType> onReceive(MessageReceive message) {
        return this;
    }
}
