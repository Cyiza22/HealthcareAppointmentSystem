public class Mian {
    public static void main(String[] args) {
        URLFetcherThread thread1 =new URLFetcherThread("https://www.example.com");
        URLFetcherThread thread2 =new URLFetcherThread("https://www.android.com/");

        Thread t1 = new Thread(thread1);
        t1.setName("Example link1");
        Thread t2 = new Thread(thread2);
        t2.setName("android");
        t1.start();
        t2.start();
        System.out.println("Main thread continues processing...");





    }
}
