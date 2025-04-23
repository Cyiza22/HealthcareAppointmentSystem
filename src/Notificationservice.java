public interface Notificationservice {
    void sendNotification(String message);
}

class EmailNotification implements Notificationservice {
    @Override
    public void sendNotification(String message) {
        System.out.println("Email Notification :" + message);
    }
}

class SMSNotification implements Notificationservice {
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS Notification :" + message);
    }
}

class PushNotification implements Notificationservice {
    @Override
    public void sendNotification(String message) {
        System.out.println("Push Notification :" + message);
    }
}