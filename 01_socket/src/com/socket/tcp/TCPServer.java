package com.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: zhihu
 * Description: TCP服务器端
 * Date: Create in 2019/4/21 3:09
 */
public class TCPServer {
    
    public static void main(String[] args) throws IOException {
        System.out.println("tcp协议服务器端启动...");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        // 创建服务器端连接
        ServerSocket serverSocket = new ServerSocket(8080);
        try {
            while (true) {
                // 接受客户端请求 阻塞功能
                Socket accept = serverSocket.accept();
                newCachedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream inputStream = accept.getInputStream();
                            // 将字节流转换成String类型
                            byte[] bytes = new byte[1024];
                            int len = inputStream.read(bytes);
                            String result = new String(bytes, 0, len);
                            System.out.println("服务器端接受客户端内容:" + result);
                            OutputStream outputStream = accept.getOutputStream();
                            outputStream.write("this is yes itmayiedu.com".getBytes());
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                });
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            serverSocket.close();
        }
    }
}
