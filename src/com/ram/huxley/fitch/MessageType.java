package com.ram.huxley.fitch;

public enum MessageType {
    RED("RED"),YELLOW("YELLOW"),BLUE("BLUE");

    private String type;

    MessageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
