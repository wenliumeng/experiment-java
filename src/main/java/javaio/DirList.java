package javaio;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 目录列表器
 */
public class DirList {

    public static void main(String[] args) {
        args = new String[]{"access"};
        File file = new File("./src/main/java");
        File[] files = file.listFiles();

        System.out.println(Arrays.asList(files));

        String[] list;
        if (args.length == 0)
            list = file.list();
        else
            list = file.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String s : list)
            System.out.println(s);
    }
}


class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}