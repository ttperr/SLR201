package ioStreams;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public Client() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            SocketAddress socketAddress = new InetSocketAddress(address, Server.PORT);
            this.socket = new Socket();
            this.socket.connect(socketAddress);

            OutputStream os = this.socket.getOutputStream();
            OutputStreamWriter ow = new OutputStreamWriter(os);
            this.writer = new PrintWriter(ow);

            InputStream is = this.socket.getInputStream();
            InputStreamReader ir = new InputStreamReader(is);
            this.reader = new BufferedReader(ir);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.sendMessage("World\n");
        String msg = client.readMessage();
        System.out.println("Server said : " + msg);

    }

    public String readMessage() {
        String message = null;
        try {
            message = this.reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    public void sendMessage(String msg) {
        this.writer.println(msg);
        this.writer.flush();
    }
}
