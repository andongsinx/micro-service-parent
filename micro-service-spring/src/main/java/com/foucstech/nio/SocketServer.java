package com.foucstech.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author wuandong
 * @classname SocketServer
 * @date 2020/5/10 9:11
 */
public class SocketServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 9999));
        //serverSocketChannel.configureBlocking(false);
        while (true) {
            //System.out.println("server listening.....");
            SocketChannel socketChannel = serverSocketChannel.accept();
            handleSocketChannel(socketChannel);
            Thread.sleep(1);
        }
    }

    public static void handleSocketChannel(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        if (socketChannel != null) {
            //socketChannel.configureBlocking(false);
            int readLen = socketChannel.read(buffer);
            while (readLen > 0) {
                buffer.flip();
                if (buffer.hasRemaining()) {
                    System.out.println(new String(buffer.array()));
                }
                buffer.clear();
                System.out.println("clear.........");
                readLen = socketChannel.read(buffer);
            }
            buffer.clear();
            buffer.put(buildContent());
            buffer.flip();
            socketChannel.write(buffer);
            //buffer.clear();
            socketChannel.close();
        }

    }


    public static byte[] buildContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK").append("\r\n\r\n");
        //sb.append("Content-Type: text/html;charset=utf-8").append("\r\n");
        sb.append("server send message..................");
        return sb.toString().getBytes();
    }


}
