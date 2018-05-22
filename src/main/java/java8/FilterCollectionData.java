package java8;

import java.util.HashMap;
import java.util.Map;

/**
 * 过滤集合中的数据
 *
 * @author bfei
 * @date 2018/5/25
 */
public class FilterCollectionData {

	public static void main(String[] args) {
		new FilterCollectionData().filterCollectionData();
	}

	void filterCollectionData() {
		Map<Long, String> customerMap = new HashMap<>();
		customerMap.put(1L, "aaaa");
		customerMap.put(2L, "bbbb");
		customerMap.put(3L, "cccc");
		String customerId = "bbbb";
		customerMap.values().removeIf(o -> customerId.equals(o));
		customerMap.values().forEach(System.out::println);
	}
}
