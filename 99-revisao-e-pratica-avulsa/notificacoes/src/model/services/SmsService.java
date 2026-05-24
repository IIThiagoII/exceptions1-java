package model.services;

import model.entities.Notification;

public class SmsService implements NotificationService {

    @Override
    public void send(Notification notification) {
        System.out.println("📱 [SMS enviado para " + notification.getReceiver() + "]");
        System.out.println("Mensagem: " + notification.getMessage());
        System.out.println("----------------------------------------");
    }
}