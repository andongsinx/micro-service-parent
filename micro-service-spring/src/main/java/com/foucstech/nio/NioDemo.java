package com.foucstech.nio;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author wuandong
 * @classname NioDemo
 * @date 2020/5/6 9:09
 */
public class NioDemo {

    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(new File("D:\\program\\micro-service-parent\\micro-service-spring\\src\\main\\resources\\logs\\access.log"));
        //FileChannel channel = in.getChannel();
        //ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //int read = channel.read(byteBuffer);

       /* while (read != -1) {
            byteBuffer.flip();

            //System.out.println(new String(byteBuffer.array()));
            byteBuffer.clear();
            read = channel.read(byteBuffer);
        }*/
        //FileChannel channel = FileChannel.open(logs, StandardOpenOption.READ);
        byte[] buffer = new byte[3];

        BufferedInputStream bin = new BufferedInputStream(in);

        int len = 0;
        //bin.mark(1);
        bin.read(buffer);
        System.out.println(new String(buffer));
        //bin.reset();
        buffer = new byte[1024];

        bin.read(buffer);
        System.out.println(new String(buffer));
        System.out.println("--------------------");
        /*while ( (len = bin.read(buffer,0,buffer.length)) !=-1){
            System.out.print(new String(buffer,0,len));
        }
        bin.reset();
        System.out.println();
        while ( (len = bin.read(buffer,0,buffer.length)) !=-1){

            System.out.print(new String(buffer,0,len));
        }
        bin.reset();
        System.out.println();
        while ( (len = bin.read(buffer,0,buffer.length)) !=-1){

            System.out.print(new String(buffer,0,len));
        }*/



    }

}
