//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

<<<<<<< HEAD
        PairTest.Pair<String, Integer> pair1 = new PairTest.Pair<>("Age", 25);

        PairTest.Pair<Integer, String> pair2 = new PairTest.Pair<>(404, "Not Found");


        System.out.println(pair1);
        System.out.println(pair2);
    }
}

=======
        Notificationservice email = new EmailNotification();
        Notificationservice sms = new SMSNotification();
        Notificationservice push = new PushNotification();

        email.sendNotification("Welcome to our platform via Email!");
        sms.sendNotification("Your code is sent to your platform via SMS!");
        push.sendNotification("You have a new friend request via push notification.");

    }
}
>>>>>>> b1c548b67b147ee5df3754118c338a3fce0b4a8b
