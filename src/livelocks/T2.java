package livelocks;

public class T2 extends Thread {

    private final LivelockExample livelockExample = new LivelockExample();

    public final void run() {
        livelockExample.operation2();
    }

}
