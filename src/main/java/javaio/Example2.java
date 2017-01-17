package javaio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 统计代码量
 * Created by seyMour on 2017/1/16.
 */
public class Example2 {
    static BufferedReader BR = null;
    static long Count = 0;

    public static void main(String[] args) throws IOException {
        Trvs(new File("E:\\idea_workspace\\QiwuOffice\\src\\main\\java"));
        System.out.print(Count);
    }

    static void Trvs(File f) throws IOException {
        File[] childs = f.listFiles();
        for (File child : childs != null ? childs : new File[0]) {
            if (child.isFile()) {
                BR = new BufferedReader(new FileReader(child));
                while (BR.readLine() != null) Count += 1;
            } else Trvs(child);
        }
    }
}
