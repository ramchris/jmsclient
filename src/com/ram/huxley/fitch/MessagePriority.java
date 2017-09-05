package com.ram.huxley.fitch;

public enum MessagePriority {
    PRIORITY1(1), PRIORITY2(2), PRIORITY3(3);

    private int priority;

    MessagePriority(int value) {
        priority = value;
    }

    public int getPriority() {
        return priority;
    }
}
