package com.amigoscode._3_oop._5_dependencyinjection;

/**
 * Exercise: Dependency Injection - Notification Service
 *
 * Build a notification system where the NotificationService does NOT
 * create its own dependencies. Instead, it receives them through its
 * constructor (constructor injection). This makes the code flexible,
 * testable, and follows the Dependency Inversion Principle.
 *
 * Key concepts:
 * - Defining an interface for the dependency
 * - Constructor injection (passing dependencies via constructor)
 * - Swapping implementations without changing the dependent class
 * - Programming to an interface
 */

interface MessageSender{
        void send(String to, String message);
}


class EmailSender implements MessageSender{

    @Override
    public void send(String to, String message) {
        System.out.printf("[Email] Sending to %s: %s\n", to, message);
    }
}

class SmsSender implements MessageSender{

    @Override
    public void send(String to, String message) {
        System.out.printf("[SMS] Sending to %s: %s\n", to, message);
    }
}


class NotificationService{
    private final MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    void sendNotification(String to, String message){
        messageSender.send(to, message);
    }
}

class NotificationDemo {
    public static void main(String[] args) {
        MessageSender emailSender = new EmailSender();
        NotificationService mail = new NotificationService(emailSender);
        mail.sendNotification("alice@example.com", "Hello via email!");

        MessageSender msgSender = new SmsSender();
        NotificationService sms = new NotificationService(msgSender);
        sms.sendNotification("+1234567890", "Hello via SMS!");

        MessageSender sender = new EmailSender();
        NotificationService ns = new NotificationService(sender);
        ns.sendNotification("Ope", "You're a Dev!");
        sender = new SmsSender();
        sender.send("johndoe@gmail.com", "Hello John");
    }
}
