package com.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Author: zhihu
 * Description: UDP客户端
 * Date: Create in 2019/4/21 2:53
 */
public class UDPClient {
    
    public static void main(String[] args) throws IOException {
        System.out.println("udp客户端启动连接...");
        //不传入端口号 作用客户端  创建一个socket客户端
        DatagramSocket ds = new DatagramSocket();
        String str = "蚂蚁课堂";
        byte[] strBytes = str.getBytes();
        DatagramPacket dp = new DatagramPacket(strBytes, strBytes.length, InetAddress.getByName("127.0.0.1"), 8080);
        ds.send(dp);
        ds.close();
    }
}
