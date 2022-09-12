package basicThread;

import java.util.Arrays;

public class MainCommandBuffer {
    public static void main(String[] args) {
        CommandBuffer commandBuffer = new CommandBuffer();
        PushThread pushThread = new PushThread(commandBuffer);
        PullThread pullThread = new PullThread(commandBuffer);

        pushThread.start();
        pullThread.start();

        try {
            pushThread.join();
            pullThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished");
        System.out.println("commandBuffer.getNextStoreIdx() = " + commandBuffer.getNextStoreIdx());
        System.out.println("commandBuffer.getNextTakeIdx() = " + commandBuffer.getNextTakeIdx());
        System.out.println("commandBuffer.getCommands() = " + Arrays.toString(commandBuffer.getCommands()));
    }
}

