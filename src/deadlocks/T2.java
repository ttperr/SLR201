package deadlocks;

public class T2 extends Thread {

    private final DeadlockExample deadlockExample = new DeadlockExample();

    public final void run() {
        deadlockExample.operation2();
    }

}
