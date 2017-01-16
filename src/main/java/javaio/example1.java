package javaio;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 合并日志
 * Created by seyMour on 2017/1/16.
 */
public class Example1 {

    public static void main(String[] args) throws Exception {
//        FileChannel fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\Annual summary.txt").getChannel();
//        File file = new File("F:\\xxx\\行xx\\工作日志\\2015\\2016年1月1.txt");
        Example1 example1 = new Example1();

        List<File> files = Arrays.asList(new File("F:\\xxx\\行x\\工作日志\\2015\\").listFiles(example1.new filenameFilter("2016")));

        Collections.sort(files, (o1, o2) -> {
            int month1 = Integer.parseInt(o1.getName().substring(o1.getName().indexOf("年") + 1, o1.getName().indexOf("月")));
            int month2 = Integer.parseInt(o2.getName().substring(o2.getName().indexOf("年") + 1, o2.getName().indexOf("月")));
            System.out.println(month1 + " " + month2);
            return month1 - month2;
        });

        /*if (file.createNewFile()) {
            //新建测试数据
            FileOutputStream is = new FileOutputStream(file);
            byte[] b1 = "测试数据".getBytes();
            is.write(b1);
        }*/

        for (File fileS : files) {
            FileInputStream is = new FileInputStream(fileS);
            FileChannel fis = is.getChannel();

            //按行读
            RandomAccessFile asf = new RandomAccessFile(fileS, "r");
            String s;
            String last = null;

            FileWriter writer = new FileWriter("C:\\Users\\Administrator\\Desktop\\Annual summary.txt", true);
            while ((s = asf.readLine()) != null) {
                String s1 = new String(s.getBytes("ISO-8859-1"), "GB2312");
                if (s1.length() > 12) {
                    if (last == null) {
                        writer.write(s1.substring(12, s1.length()));
                        writer.write("\n");
                    } else {
                        System.out.println(last + " : " + s1.substring(12, s1.length()));

                        if (!last.equals(s1.substring(12, s1.length()).trim())) {
                            writer.write(s1.substring(12, s1.length()));
                            writer.write("\n");
                        }
                    }
                    last = s1.substring(12, s1.length()).trim();
                }
                if (s1.length() > 0 && s1.length() < 6) {
                    writer.write(s1);
                    writer.write("\n");
                }
            }
            writer.close();
            fis.close();
        }
    }

    class filenameFilter implements FilenameFilter {

        private String str;

        public filenameFilter(String str) {
            this.str = str;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.contains(str);
        }
    }

}
