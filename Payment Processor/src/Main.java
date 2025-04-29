//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        CreditCard creditCard = new CreditCard(200.0);
        PayPal payPal = new PayPal(100.0, "muhimpunduan@gmail.com");
        Bitcoin bitcoin = new Bitcoin(300.0, "BTC123456");
        ApplePay applePay = new ApplePay(85.0, "Device9");

        processor.processPayment(creditCard);
        processor.processPayment(payPal);
        processor.processPayment(bitcoin);
        processor.processPayment(applePay);

    }
}