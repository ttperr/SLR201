package livelocks;

public class T1 extends Thread {

    private final LivelockExample livelockExample = new LivelockExample();

    public final void run() {
        livelockExample.operation1();
    }

}
