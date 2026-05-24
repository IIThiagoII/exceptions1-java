package model.entities;

import java.time.LocalDateTime;

public class Notification {
    private String receiver;
    private String message;
    private LocalDateTime timestamp;

    public Notification(String receiver, String message) {
        this.receiver = receiver;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}