package model.services;

import model.entities.Notification;

public class NotificationSender {

    private NotificationService notificationService;

    public NotificationSender(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendAlert(String destination, String alertMessage) {

        Notification notification = new Notification(destination, alertMessage);

        notificationService.send(notification);
    }
}