package app;

import java.time.format.DateTimeFormatter;
import model.entities.Notification;
import model.services.EmailService;
import model.services.NotificationSender;
import model.services.SmsService;

public class Program {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE SEGURANÇA BANCÁRIA ===");
        System.out.println("----------------------------------------");


        System.out.println("Cenário A: Alerta via Celular");
        NotificationSender smsSender = new NotificationSender(new SmsService());
        smsSender.sendAlert("(86) 99999-1234", "Tentativa de login suspeita detectada em Teresina-PI.");


        System.out.println("Cenário B: Alerta via E-mail");
        NotificationSender emailSender = new NotificationSender(new EmailService());
        emailSender.sendAlert("thiago.dev@email.com", "Seu limite do Pix foi alterado com sucesso.");


        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Notification log = new Notification("Sistema", "Logs processados");
        System.out.println("Monitoramento finalizado em: " + log.getTimestamp().format(fmt));
    }
}