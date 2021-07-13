package com.example.messagingstompwebsocket;

public class MessageDto {

    private String currentRoom;
    private String name;
    private String content;

    public MessageDto(String currentRoom, String name, String content) {
        this.currentRoom = currentRoom;
        this.name = name;
        this.content = content;
    }

    public String getCurrentRoom() {
        return currentRoom;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
