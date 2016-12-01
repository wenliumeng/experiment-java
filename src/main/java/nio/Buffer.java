package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Buffer相关
 * Created by seyMour on 2016/12/1.
 * ☞seyMour☜
 */
public class Buffer {

    public static void main(String[] args) throws IOException {
        ByteBuffer head = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray = {head,body};
        //scatter 分散顺序写入buffer中
        FileChannel channel = new RandomAccessFile("","").getChannel();
        channel.read(bufferArray);

        //gathering 聚合都入到channel中
        channel.write(bufferArray);
    }

    //通道间的数据传输
    void testTransfer() throws IOException{
        FileChannel fromChannel = new RandomAccessFile("","").getChannel();
        FileChannel toChannel   = new RandomAccessFile("","").getChannel();

        //下面这两句效果一样
        toChannel.transferFrom(fromChannel,0,fromChannel.size());
        fromChannel.transferTo(0,fromChannel.size(),toChannel);
    }

}
