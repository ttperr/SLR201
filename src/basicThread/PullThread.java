package basicThread;

public class PullThread extends Thread {
    private final CommandBuffer commandBuffer;

    public PullThread(CommandBuffer commandBuffer) {
        this.commandBuffer = commandBuffer;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            String command = commandBuffer.popCommand();
            System.out.println("Pulled " + command);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
