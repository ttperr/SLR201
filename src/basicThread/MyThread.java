package basicThread;

public class MyThread extends Thread {
    private final String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
