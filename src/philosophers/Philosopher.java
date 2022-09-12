package philosophers;

public class Philosopher extends Thread {
    private final int id;
    private int state; // 0 = thinking, 1 = hungry, 2 = eating
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.state = 0;
    }

    public String toString() {
        String currentState;
        if (state == 0) {
            currentState = "thinking";
        } else if (state == 1) {
            currentState = "hungry";
        } else {
            currentState = "eating";
        }
        return "Philosopher [id =" + id + ", leftFork = " + leftFork + ", rightFork = " + rightFork + ", state = " + currentState + "]";
    }

    public final void think() {
        this.state = 0; // thinking
        Log.msg("Philosopher " + id + " is thinking");
        try {
            Thread.sleep((long) (Math.random() * 257));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eat();
    }

    public synchronized void eat() {
        this.state = 1; // hungry
        Log.msg("Philosopher " + id + " is hungry");
        try {
            while (true) {
                if (!leftFork.isTaken() || leftFork.isTakenBy() == this.id) {
                    leftFork.take(id);
                    if (!rightFork.isTaken()) {
                        rightFork.take(id);
                        this.state = 2; // eating
                        Log.msg("Philosopher " + id + " is eating");
                        Thread.sleep(1000);
                        leftFork.release();
                        rightFork.release();
                        notifyAll();
                        break;
                    } else {
                        wait();
                    }
                } else {
                    wait();
                }
            }
            think();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            think();
        }
    }

}
