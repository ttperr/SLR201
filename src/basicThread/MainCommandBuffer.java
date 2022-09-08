package basicThread;

public class MainCommandBuffer {
    public static void main(String[] args) {
        CommandBuffer commandBuffer = new CommandBuffer();
        PushThread pushThread = new PushThread(commandBuffer);
        PullThread pullThread = new PullThread(commandBuffer);

        pushThread.start();
        pullThread.start();

        try {
            pushThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            pullThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

