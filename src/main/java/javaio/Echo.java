package javaio;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 从标准流中读取
 * Created by seyMour on 2017/1/13.
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        //标准输入System.in不能直接用，必须包装后才能
        /*BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null && s.length() != 0)
            System.out.println(s);*/

        //标准输出流System.out可以直接使用
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("hello world");
    }
}
