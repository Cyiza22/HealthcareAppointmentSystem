
public class CounterMain {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                Count.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                Count.increment();
            }
        });

        t1.start();
        t1.join();
        t2.start();
        t2.join();

        System.out.println(Count.getCount());
    }
}
