package vitals;

public class ConsoleMessageHandler implements CriticalMessageHandler {

    @Override
    public void handle(String message) {
        System.out.println(message);
        animateWarning();
    }

    private void animateWarning() {
        try {
            for (int i = 0; i < 6; i++) {
                System.out.print("\r* ");
                Thread.sleep(1000);
                System.out.print("\r *");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
