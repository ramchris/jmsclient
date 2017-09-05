package com.ram.huxley.fitch;

import java.util.Comparator;

/**
 * Message is immutable so that it is inherently thread safe in a multi threaded environment
 */
public final class Message implements Comparable<Message>{
    private final String message;
    private final MessageType messageType;
    private final MessagePriority priority;
    private final long time;

    public Message(String message, MessageType messageType, MessagePriority priority, long time) {
        this.message = message;
        this.messageType = messageType;
        this.priority = priority;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public MessagePriority getPriority() {
        return priority;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", messageType=" + messageType +
                ", priority=" + priority +
                ", time=" + time +
                '}';
    }

    @Override
    public int compareTo(Message o) {
        return Comparator.comparing(Message::getMessageType)
                .thenComparing(Message::getPriority)
                .thenComparingLong(Message::getTime)
                .compare(this, o);


    }
}
