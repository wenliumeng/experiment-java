package java8;

import java.util.function.Predicate;

@FunctionalInterface
public interface FilterStartPredicate<T> {

	//函数式接口只能包含一个抽象方法，但因为默认方法不算抽象方法，所以可以有默认方法
	Predicate<T> filter(String a, String b);
}
