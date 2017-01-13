package javaio;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 还可以再聚拢于一个方法内
 */
public class DirList2 {
    public static FilenameFilter filter(String regex) {
        return new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        args = new String[]{"access"};
        File path = new File("./src/main/java");
        String[] list = path.list(filter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String s : list)
            System.out.println(s);
    }
}
