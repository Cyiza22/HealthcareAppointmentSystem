//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Notificationservice email = new EmailNotification();
        Notificationservice sms = new SMSNotification();
        Notificationservice push = new PushNotification();

        email.sendNotification("Welcome to our platform via Email!");
        sms.sendNotification("Your code is sent to your platform via SMS!");
        push.sendNotification("You have a new friend request via push notification.");

    }
}
