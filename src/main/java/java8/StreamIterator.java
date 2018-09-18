package java8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 接口
 *
 * @author bfei
 * @date 2018/9/3
 */
public class StreamIterator {

	public static void main(String[] args) {
		int[] ints = IntStream.iterate(0, i -> i + 10).toArray();
		for (int o :
				ints) {
			System.out.println(o);
		}
	}
}
