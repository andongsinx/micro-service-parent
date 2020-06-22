package com.foucstech.nio;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author wuandong
 * @classname SocketClient
 * @date 2020/5/13 16:15
 */
public class SocketClient {


    public static void main(String[] args) throws IOException {
        //ServerSocketChannel channel = ServerSocketChannel.open();
        SocketChannel channel = SocketChannel.open();
        channel.bind(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 19999)).connect(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 9999));
        //channel.configureBlocking(false);
        //Selector selector = Selector.open();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("client send message,...........".getBytes());
        buffer.flip();
        channel.write(buffer);
        buffer.clear();
        buffer.flip();
        channel.read(buffer);
        System.out.println(new String(buffer.array()));


        //channel.close();

        /*channel.register(selector, SelectionKey.OP_READ);
        while (true) {
            int readyChannel = selector.selectNow();
            if (readyChannel == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    System.out.println("acceptable....");
                }
                if (key.isConnectable()) {
                    System.out.println("connectable");
                }
                if (key.isValid()) {
                    System.out.println("valid....");
                }
                if (key.isWritable()) {
                    System.out.println("writable");
                }
                iterator.remove();
            }


        }
*/

    }
}
