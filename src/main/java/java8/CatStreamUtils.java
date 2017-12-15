package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Arctic
 */
public class CatStreamUtils {

	public static Stream<String> concat(List<String> l1 ,String[] l2,Set<String> l3) {
		return Stream.of(l1.stream(), Arrays.stream(l2),l3.stream()).flatMap(Function.identity());
	}

	public static Stream<String> listToStream(List<Collection<String>> conllections) {
		return conllections.stream().flatMap(new Function<Collection<String>, Stream<? extends String>>() {
			@Override
			public Stream<? extends String> apply(Collection<String> strings) {
				return strings.stream();
			}
		});
	}

	public static Stream<String> listToStream1(List<Collection<String>> collections) {
		return collections.stream().flatMap((Collection<String> strings) -> strings.stream());
	}

	public static Stream<String> listToStream2(List<Collection<String>> collections) {
		return collections.stream().flatMap((strings) -> strings.stream());
	}

	public static Stream<String> listToStream3(List<Collection<String>> collections) {
		return collections.stream().flatMap(Collection::stream);
	}

	public void TestConcat() {
		List<String> l1 = new ArrayList<>();
		l1.add("1");
		l1.add("2");

		String[] l2 = new String[]{"3","4"};

		Set<String> l3 = new HashSet<>();
		l3.add("5");
		l3.add("6");

		concat(l1,l2,l3).forEach(System.out::println);
	}

	public void TestListToStream() {
		List<String> l1 = new ArrayList<>();
		l1.add("1");
		l1.add("2");

		List<Collection<String>> ll1 = new ArrayList<>();
		ll1.add(l1);
		(ll1).forEach(System.out::println);
		listToStream3(ll1).forEach(System.out::println);
	}

}
