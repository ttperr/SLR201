package philosophers;

public class Philosopher extends Thread {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private int state; // 0 = thinking, 1 = hungry, 2 = eating

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
        return "Philosopher [id = " + id + ", leftFork = " + leftFork + ", rightFork = " + rightFork + ", state = " + currentState + "]";
    }

    public synchronized void think() {
        this.state = 0; // thinking
        Log.msg("Philosopher " + id + " is thinking");
        try {
            Thread.sleep((long) (Math.random() * 256));
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
                if (leftFork.isFree() || leftFork.isTakenBy() == this.id) {
                    leftFork.take(id);
                    if (rightFork.isFree()) {
                        rightFork.take(id);
                        this.state = 2; // eating
                        Log.msg("Philosopher " + id + " is eating");
                        Thread.sleep(256);
                        leftFork.release();
                        rightFork.release();
                        Log.msg("Philosopher " + id + " has finished eating and released the forks: " + leftFork + " and " + rightFork);
                        notifyAll();
                        break;
                    } else {
                        Log.msg("Philosopher " + id + " is waiting for " + rightFork);
                        wait();
                    }
                } else {
                    Log.msg("Philosopher " + id + " is waiting for " + leftFork);
                    wait();
                }
            }
            think();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        think();
    }

}
