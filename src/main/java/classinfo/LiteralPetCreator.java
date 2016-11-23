package classinfo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 修饰过的pet生成器
 * Created by seyMour on 2016/11/23.
 * ☞seyMour☜
 */
public class LiteralPetCreator extends PetCreator {

    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(Dog.class,Cat.class,smallDog.class));

    private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Dog.class),allTypes.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}
