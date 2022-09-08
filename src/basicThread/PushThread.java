package basicThread;

public class PushThread extends Thread {
    private final CommandBuffer commandBuffer;

    public PushThread(CommandBuffer commandBuffer) {
        this.commandBuffer = commandBuffer;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            commandBuffer.pushCommand("command " + i);
            System.out.println("Pushed command " + i);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
