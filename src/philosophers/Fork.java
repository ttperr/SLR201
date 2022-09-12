package philosophers;

public class Fork {
    private boolean taken;
    private int takenBy;
    private final int id;

    public Fork(int id) {
        this.id = id;
        this.taken = false;
        this.takenBy = -1;
    }

    public String toString() {
        return "Fork: " + id;
    }

    public synchronized void take(int id) {
        this.taken = true;
        this.takenBy = id;
    }

    public synchronized void release() {
        this.taken = false;
        this.takenBy = -1;
    }

    public synchronized boolean isTaken() {
        return this.taken;
    }

    public synchronized int isTakenBy() {
        return this.takenBy;
    }
}
