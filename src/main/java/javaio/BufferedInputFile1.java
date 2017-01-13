package javaio;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * 字节输入流无法按行来读
 * Created by seyMour on 2017/1/13.
 */
public class BufferedInputFile1 {

    public static List<String> read(String filename) throws IOException {
        File file = new File(filename);
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(file)
        );
        int bytesReader;
        byte[] buffer = new byte[1024];
        List<String> list = new LinkedList<>();
        while ((bytesReader = in.read(buffer)) != -1) {
            String str = new String(buffer, 0, bytesReader);
            list.add(str);
        }

        in.close();
        return list;
    }

    public static List<String> read1(String filename) throws IOException {
        File file = new File(filename);
        BufferedReader in = new BufferedReader(new FileReader(file));
        LineNumberReader in1 = new LineNumberReader(new FileReader(file));
        String line;
        List<String> list = new LinkedList<>();
        while ((line = in1.readLine()) != null) {
            list.add(line);
        }
        in1.close();
        return list;
    }

    public static void read2(String filename) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("./src/main/java/javaio/BufferedInputFile.java")
                )
        );

        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(filename))
        );

        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ":" + s);
        out.close();
//        System.out.println(BufferedInputFile.read(filename));
    }

    public static void main(String[] args) throws IOException {
//        List list = read1("./src/main/java/javaio/BufferedInputFile.java");
//        for (ListIterator it = list.listIterator(list.size()); it.hasPrevious(); ) {
//            System.out.println(it.previous());
//        }
//        System.out.println(read1("./src/main/java/javaio/BufferedInputFile.java"));

        read2("./src/main/java/javaio/BufferedInputFile.java");

    }

}
