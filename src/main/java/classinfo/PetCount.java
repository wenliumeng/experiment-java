package classinfo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * instanceof 样式的计数器
 * Created by seyMour on 2016/11/23.
 * ☞seyMour☜
 */
public class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1);
        }
    }

    //优化
    static class PetCounter1 extends LinkedHashMap<Class<? extends Pet>, Integer> {

        public PetCounter1(){

        }

        public void count1(Pet pet) {
            System.out.println(entrySet().size());
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                if (pair.getKey().isInstance(pet))
                    put(pair.getKey(), pair.getValue() + 1);
            }
        }
    }

    /*public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(10)) {
            System.out.println(pet.getClass().getName());
            if (pet instanceof Dog)
                counter.count("dog");
            if (pet instanceof Cat)
                counter.count("Cat");
        }
        System.out.println(counter);
    }*/

    public static void main(String[] args) {
//        countPets(new ForNameCreator());


        PetCounter1 petCounter1 = new PetCounter1();
        for (Pet pet: new ForNameCreator().createArray(10)) {
            System.out.println(pet.getClass().getName());
            petCounter1.count1(pet);
        }
        System.out.println(petCounter1.size());
    }
}
