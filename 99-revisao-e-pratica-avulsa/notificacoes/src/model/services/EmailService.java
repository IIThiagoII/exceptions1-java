package model.services;

import model.entities.Notification;

public class EmailService implements NotificationService {

    @Override
    public void send(Notification notification) {
        System.out.println("✉️ [E-mail enviado para " + notification.getReceiver() + "]");
        System.out.println("Assunto: ALERTA DE SEGURANÇA BANCÁRIA");
        System.out.println("Conteúdo: " + notification.getMessage());
        System.out.println("----------------------------------------");
    }
}