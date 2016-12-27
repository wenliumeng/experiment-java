package holdobject;

import generic.Generator;

import java.util.ArrayList;

/**
 * xxx
 * Created by seyMour on 2016/12/20.
 * ☞seyMour☜
 */
public class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> gen,int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen,int quantity) {
        return new CollectionData<>(gen, quantity);
    }

}
