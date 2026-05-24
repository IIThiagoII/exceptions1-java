package model.services;

import model.entities.Notification;

public interface NotificationService {
    void send(Notification notification);
}