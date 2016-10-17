package holdobject;

import java.util.*;

public class holdObject {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("2", "r", "c", "g", "t", "aa"));

        HashMap<String, String> map = new HashMap<>();
        map.put("f", "d");
        System.out.println(list);
        System.out.println(map.toString());

        ListIterator<String> it = list.listIterator();

        while(it.hasNext())
            System.out.println(it.next() + ", " + it.nextIndex() + ", "+ it.previousIndex() + ";");
        System.out.println();
        while (it.hasPrevious())
            System.out.println(it.previous());
        it = list.listIterator(1);
        System.out.println("-");
        while (it.hasPrevious())
            System.out.println(it.previous());


        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++)
            priorityQueue.offer(random.nextInt(i+10)+"");
    }
}
