package com.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Author: zhihu
 * Description: TCP客户端
 * Date: Create in 2019/4/21 3:09
 */
public class TCPClient {
    
    public static void main(String[] args) throws IOException {
        System.out.println("socket tcp客户端启动....");
        //创建socket客户端
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我是蚂蚁课堂忠实粉丝....".getBytes());
        socket.close();
    }
}
