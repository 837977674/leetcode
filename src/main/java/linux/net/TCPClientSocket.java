package linux.net;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPClientSocket {

    private static Socket socket;

    /**
     * 是否主动发起关闭
     */
    private static boolean isLaunchClose=true;

    /**
     * 建立socket连接
     *  @param bindIp
     * @param bindPort
     * @return
     */
    public static Socket connectServerSocket(String bindIp, int bindPort) {
        try {
            socket = new Socket(bindIp, bindPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return socket;
    }

    /**
     * 关闭socket连接
     */
    public static void closeSocket(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        int bindPort = 6666;
        String bindIp = "localhost";
        Socket socket = connectServerSocket(bindIp, bindPort);
        BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String str="你好，这是我的第一个socket";

        bufferedWriter.write(str);
        //刷新输入流
        bufferedWriter.flush();
        socket.close();
    }
}
