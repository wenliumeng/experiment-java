package javaio.nio;

import java.nio.ByteBuffer;

/**
 * ByteBuffer存取数据
 * Created by seyMour on 2017/1/14.
 */
public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < bb.limit())
            if (bb.get() != 0)
                System.out.println("nonzero");
        System.out.println("i = " + i);
        bb.rewind();

        bb.asCharBuffer().put("HELLO");
        char c;
        while ((c = bb.getChar()) != 0)
            System.out.println(c + " ");
        System.out.println();
        bb.rewind();
        bb.asShortBuffer().put((short) 3214);
        System.out.println(bb.getShort());

    }
}
