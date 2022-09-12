package ioStreams;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 50000;
    private ServerSocket serverSocket;
    private Socket socket;

    private PrintWriter serverWriter;
    private BufferedReader serverReader;

    public Server() {
        try {
            this.serverSocket = new ServerSocket(Server.PORT);
            this.socket = serverSocket.accept();

            OutputStream os = this.socket.getOutputStream();
            OutputStreamWriter ow = new OutputStreamWriter(os);
            this.serverWriter = new PrintWriter(ow);

            InputStream is = this.socket.getInputStream();
            InputStreamReader ir = new InputStreamReader(is);
            this.serverReader = new BufferedReader(ir);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readMessage() {
        String message = null;
        try {
            message = this.serverReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    public void sendMessage(String msg) {
        this.serverWriter.println(msg);
        this.serverWriter.flush();
    }

    public static void main(String[] args) {
        Server server = new Server();
        String msg = server.readMessage();
        System.out.println("Client said : " + msg);
        server.sendMessage("Hello " + msg);
    }
}
