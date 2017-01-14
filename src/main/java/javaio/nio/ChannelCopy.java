package javaio.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * channel复制文件
 * Created by seyMour on 2017/1/14.
 */
public class ChannelCopy {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel in = new FileInputStream("data.txt").getChannel(),
                out = new FileOutputStream("data1.txt").getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        //-1是分界符
        while (in.read(buffer) != -1) {
            //准备缓冲器，以便可以用write读取
            buffer.flip();
            out.write(buffer);
            //write之后信息仍在缓冲器中
            buffer.clear();
        }
    }
}
