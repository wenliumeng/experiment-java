package javaio.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel的用法
 * Created by seyMour on 2017/1/14.
 */
public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        //可以在文件内随处移动FileChannel，这里移动到文件末尾
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        //调用read，告知filechannel向ByteBuffer中填充数据
        fc.read(buff);
        //必须用flip()让其他对象做好读取字节的准备
        buff.flip();
        while (buff.hasRemaining())
            System.out.print((char) buff.get());
    }
}
