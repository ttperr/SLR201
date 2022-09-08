package basicThread;

public class MainMyThread {
    public static void main(String[] args) {
        MyThread myThreadA = new MyThread("Thread A");
        MyThread myThreadB = new MyThread("Thread B");
        MyThread myThreadC = new MyThread("Thread C");

        myThreadA.start();
        myThreadB.start();
        myThreadC.start();
    }
}