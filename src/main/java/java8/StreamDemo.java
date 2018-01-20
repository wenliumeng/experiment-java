package java8;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * stream demo
 *
 * @author baofei
 * @date 2017/12/18
 */
public class StreamDemo {

	List<String> list = new ArrayList<>();

	public static void main(String[] args) {
		StreamDemo streamDemo = new StreamDemo();
		streamDemo.init();

		streamDemo.demoStreamCreatePaths();
	}

	private static void demoMapEntrySet() {
		Map<Integer, String> m = new HashMap<>();
		m.put(1, "zhang");
		m.put(2, "wang");
		m.put(3, "wang");

		List<Map.Entry<Integer, String>> wang = m.entrySet().stream().filter(s -> s.getValue().equals("wang")).collect(Collectors.toList());
		wang.forEach(System.out::println);
		System.out.println(wang.size());
		Map.Entry<Integer, String> map = wang.get(0);
		System.out.println(map.getKey());
		wang.forEach(s -> s.getKey());
		wang.forEach(s -> s.getValue());
	}

	public static class NodePath {

		public Path path;

		public NodePath(Path path) {
			this.path = path;
		}

	}

	private void demoStreamCreatePaths() {
		NodePath[] nodePaths = new NodePath[2];
		nodePaths[0] = new NodePath(FileSystems.getDefault().getPath("D:\\idea\\workspace\\experiment-java\\src\\main\\java\\java8\\StreamDemo.java"));
		nodePaths[1] = new NodePath(FileSystems.getDefault().getPath("E:/"));
		Path[] paths = Arrays.stream(nodePaths).map(np -> np.path).toArray(Path[]::new);
		Arrays.stream(paths).forEach(System.out::println);
	}

	private static void ListfilterMethodDemo(StreamDemo streamDemo) {
		//返回第一个
		Optional<String> first = streamDemo.list.stream().filter(a -> "b7".equals(a)).findFirst();
		if (first.isPresent()) {
			System.out.println(first.get());
		}

		//返回集合
		List<String> result = streamDemo.list.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
		result.forEach(System.out::println);

		List<Student> l = new ArrayList<>();
		Student s1 = new Student("1", "zhang");
		Student s2 = new Student("2", "wang");
		l.add(s1);
		l.add(s2);

		System.out.println("------抽取对象中的所有id------");
		List<String> collect = l.stream().map(Student::getId).collect(Collectors.toList());
		collect.forEach(System.out::println);
	}

	void init() {
		list.clear();
		list.add("1");
		list.add("2");
		list.add("a");
		list.add("3");
		list.add("a3");
		list.add("b7");
	}

	void filter() {
		list.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
	}

	Predicate<? super String> getPredicate(CustomPredicate<Boolean> customPredicate, String a, String b) {
		return customPredicate.or(a, b);
	}

	void filter1() {
		//使用Predicate默认的or
		list.stream().filter(((Predicate<String>) s -> s.startsWith("a")).or(s -> s.startsWith("b"))).forEach(System.out::println);
	}

	void filter2() {
		//要使形如"String::startsWith"的参数生效，形参必须有@FunctionalInterface
		//list.stream().filter(getPredicate(String::startsWith, "a", "b")).forEach(System.out::println);

		list.stream().filter(((CustomPredicate<Boolean>) String::startsWith).or("a", "b")).forEach(System.out::println);
	}

	@FunctionalInterface
	public interface CustomPredicate<T> {

		T filter(String a, String b);

		default Predicate<String> or(String a, String b) {
			return ((Predicate<String>) (String s) -> s.startsWith(a)).or((String s) -> s.startsWith(b));
		}
	}

}
