package java8;

import com.sun.org.apache.xerces.internal.impl.xs.util.StringListImpl;
import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Stream Sort
 *
 * @author baofei
 * @date 2017/12/19
 */
public class StreamSortDemo {

	public static void main(String[] args) {
		sortDemo();
		mapDemo();
		matchDemo();
		countDemo();
		reduceDemo();
//		parallelDemo();
		mapNewDemo();
	}

	private static void mapNewDemo() {
		System.out.println("-----------map------------");
		Map<String,String> map = new HashMap(3);
		//如果存在不覆盖，补漏
		map.putIfAbsent("a","AA");
		map.putIfAbsent("a", "BB");
		map.put("b", "KK");
		map.put("b", "KK1");
		map.forEach((key,value) -> System.out.println(value));

		Map<Integer, String> map1 = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map1.putIfAbsent(i, "val" + i);
		}
		System.out.println(map1.get(3));

		//如果存在就操作
		map1.computeIfPresent(3, (val, num) -> val + " - "+ num);
		System.out.println("首参 - 次参  -> " + map1.get(3));


		map1.computeIfPresent(9, (val, num) -> null);
		System.out.println("computeIfPresent 9 : " +map1.get(9));


		map1.computeIfAbsent(23,c -> "val + param:"+c);
		System.out.println("computeIfAbsent 23 : " + map1.get(23));

		System.out.println("map1.get(4) -> " + map1.get(4));
		map1.computeIfAbsent(4, num -> "bbbcm");
		System.out.println("map1.get(4) -> " + map1.get(4));
		map1.computeIfPresent(4, (a,b) -> "bbbcm"+a);
		System.out.println("map1.get(4) -> " + map1.get(4));

		System.out.println("merge val6: " + map1.get(6));
		map1.merge(6,"val6",(value,newValue) -> value.concat(newValue));
		System.out.println("merge val6: " + map1.get(6));

		map1.merge(6,"concat",(value,newValue) -> value.concat(newValue));
		System.out.println("merge concat: " + map1.get(6));
	}

	private static void parallelDemo() {
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}

		long t0 = System.nanoTime();
		long count = values.stream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));

		long t0p = System.nanoTime();
		long countp = values.parallelStream().sorted().count();
		System.out.println(countp);
		long t1p = System.nanoTime();
		long millisp = TimeUnit.NANOSECONDS.toMillis(t1p - t0p);
		System.out.println(String.format("parallel sort took: %d ms", millisp));
	}

	private static void reduceDemo() {
		System.out.println("-----------count------------");

		List<String> list = new ArrayList<>();
		list.add("h");
		list.add("a4");
		list.add("a2");
		list.add("p");

		Optional<String> optional = list.stream()
				.sorted()
				.reduce((s1, s2) -> s1 + "#" + s2);

		optional.ifPresent(System.out::println);
	}

	private static void countDemo() {
		System.out.println("-----------count------------");

		List<String> list = new ArrayList<>();
		list.add("h");
		list.add("a4");
		list.add("a2");
		list.add("p");

		long count = list.stream()
				.filter(s -> s.startsWith("a"))
				.count();

		System.out.println(count);
	}

	private static void matchDemo() {
		System.out.println("-----------match------------");

		List<String> list = new ArrayList<>();
		list.add("h");
		list.add("a4");
		list.add("a2");
		list.add("p");
		boolean anyStartWithA = list.stream()
				.anyMatch(s -> s.startsWith("a"));

		boolean allStartWithA = list.stream()
				.allMatch(s -> s.startsWith("a"));

		boolean noneStartWithA = list.stream()
				.noneMatch(s -> s.startsWith("z"));
	}

	private static void mapDemo() {
		System.out.println("-----------map------------");

		List<String> list = new ArrayList<>();
		list.add("h");
		list.add("p");

		list.stream()
				.map(String::toUpperCase)
				.sorted((a,b) -> b.compareTo(a))
				.forEach(System.out::println);
	}

	private static void sortDemo() {
		StringList list = new StringListImpl(new String[]{"a2","a1", "b2"}, 2);
		List<String> list1 = new ArrayList<>(list);
		list1.stream()
				.sorted()
				.filter((String s) -> s.startsWith("a"))
				.forEach(System.out::println);
		System.out.println(Arrays.asList(list1));
	}

}
