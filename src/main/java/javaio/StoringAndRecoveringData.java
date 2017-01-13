package javaio;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 存储或恢复数据
 * Created by seyMour on 2017/1/13.
 */
public class StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {
        //生成文件
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
        out.writeDouble(2.3123);
        out.writeUTF("fsdf");
        out.writeDouble(343.222);
        out.close();
//        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
//        System.out.println(in.readDouble());
//        System.out.println(in.readUTF());
//        System.out.println(in.readDouble());
    }
}
