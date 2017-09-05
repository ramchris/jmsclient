package com.ram.huxley.fitch;

import com.ram.huxley.fitch.util.DateUtil;

public class MessageBuilderFactory {

    public static Message getMessage(String type) {
        Message message = null;
        String greetings = "Hi Fitch, S&P reduced your rating to F!! LOL! Just kidding!! ";
        // Not sure 1 has higher rating or 3 . I chose 3
        MessagePriority priority = MessagePriority.PRIORITY3;
        MessageType messageType = MessageType.valueOf(type);
        if (MessageType.RED.equals(messageType))
        {
            message = new Message(greetings, MessageType.RED, priority, DateUtil.getTime(0));
        } else if (MessageType.YELLOW.equals(messageType))
        {
            message = new Message(greetings, MessageType.YELLOW, priority, DateUtil.getTime(30));
        } else if (MessageType.BLUE.equals(messageType))
        {
            message = new Message(greetings, MessageType.BLUE, priority, DateUtil.getTime(50));
        }

        return message;
    }



}
