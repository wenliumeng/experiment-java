package java8;

import java.util.HashSet;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * java8中各种接口demo
 *
 * @author baofei
 * @date 2017/12/18
 */
public class IntefaceLambdaDemo {

	void testPredicate() {
		Predicate<String> predicate = (from) -> from.equals("abc");

		System.out.println(predicate.test("a"));
		System.out.println(predicate.test("abc"));

		Predicate<Boolean> nonNull = (from) -> Objects.isNull(from);
		System.out.println(nonNull.test(null));
	}

	//Collection默认接口，剔除某些element
	void testCollectionRemoveIf() {
		HashSet<String> set = new HashSet<>();
		set.add("a1");
		set.add("b2");
		System.out.println(set.removeIf(s -> s.startsWith("a")));
		set.forEach(System.out::println);
		System.out.println(set.removeIf(s -> s.startsWith("c")));
		set.forEach(System.out::println);
	}

	public static void main(String[] args) {
		new IntefaceLambdaDemo().testCollectionRemoveIf();
	}
}
