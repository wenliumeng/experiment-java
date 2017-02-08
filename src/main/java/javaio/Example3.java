package javaio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * 计算数字
 * Created by seyMour on 2017/2/8.
 */
public class Example3 {

    public static void main(String[] args) {

//        String s = "activeDevices  2482518";
//        System.out.println(s.substring(s.indexOf("  ") + 2, s.length()));

        File file = new File("C:\\Users\\Administrator\\Desktop\\1.js");
        try {
            FileInputStream is = new FileInputStream(file);
            FileChannel fis = is.getChannel();

            RandomAccessFile asf = new RandomAccessFile(file, "r");
            String s;
            String last = null;

            FileWriter fw = new FileWriter("C:\\Users\\Administrator\\Desktop\\Annual summary.txt", true);
            int count = 0;
            while ((s = asf.readLine()) != null) {
                if (s.contains("  "))
                    count = count + Integer.parseInt(s.substring(s.indexOf("  ") + 2, s.length()));
            }
            System.out.println(count);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
