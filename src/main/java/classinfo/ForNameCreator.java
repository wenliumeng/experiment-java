package classinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Class.forName方法创建类List
 * Created by seyMour on 2016/11/23.
 * ☞seyMour☜
 */
public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "classinfo.Dog",
            "classinfo.Cat",
            "classinfo.smallDog"
    };

    private static void loader() {
        for (String name : typeNames) {
            try {
                types.add((Class<? extends Pet>)Class.forName(name));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
