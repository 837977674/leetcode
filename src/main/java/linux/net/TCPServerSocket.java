package linux.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerSocket {
    private static ServerSocket serverSocket;
    private static Socket socket;

    public static void startServerSocket(int bindPort) {
        try {
            serverSocket = new ServerSocket(bindPort);
            while(true){
                socket = serverSocket.accept();
                System.out.println("连接的客户端地址和端口为:" + socket.getRemoteSocketAddress());
                BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //读取一行数据
                String str = bufferedReader.readLine();
                //输出打印
                System.out.println(str);
                socket.close();
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        startServerSocket(6666);
    }
}