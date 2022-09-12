package deadlocks;

public class T1 extends Thread {

    private final DeadlockExample deadlockExample = new DeadlockExample();

    public final void run() {
        deadlockExample.operation1();
    }

}
