package com.foucstech.nio;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author wuandong
 * @classname FileDemo
 * @date 2020/5/11 10:48
 */
public class FileDemo{


    public static void main(String[] args) throws IOException {
        Path logs = FileSystems.getDefault().getPath("D:\\program\\micro-service-parent\\micro-service-spring\\src\\main\\resources\\logs", "access.log");
        InputStream inputStream = Files.newInputStream(logs);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        char[] buffer = new char[1024];
        int len = -1;
        while ( (len = reader.read(buffer,0,buffer.length)) > -1){
            System.out.print(new String(buffer,0,len));
        }

        FileChannel channel = FileChannel.open(logs);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = channel.read(byteBuffer);
        byteBuffer.flip();
        System.out.println(read);
        System.out.println(new String(byteBuffer.array()));


    }

}
