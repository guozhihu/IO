package com.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Author: zhihu
 * Description: UDP服务器端
 * Date: Create in 2019/4/21 2:52
 */
public class UDPServer {
    
    public static void main(String[] args) throws IOException {
        // ip地址+端口号
        System.out.println("udp服务器已经启动... 8080");
        // 创建服务器端口号 默认使用本机IP地址
        DatagramSocket ds = new DatagramSocket(8080);
        // 服务器接收客户端1024个字节
        byte[] bytes = new byte[1024];
        // 定义数据包
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        // 阻塞，等待接受客户端请求，将数据封装给数据包  如果客户端不往服务器端发送请求，就一直阻塞。
        ds.receive(dp);
        System.out.println("来源IP地址：" + dp.getAddress() + "，端口号：" + dp.getPort());
        String result = new String(dp.getData(), 0, dp.getLength());
        System.out.println("服务器端接受客户端内容:" + result);
        ds.close();
    }
}
