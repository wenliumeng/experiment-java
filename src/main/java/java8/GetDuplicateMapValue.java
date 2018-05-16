package java8;

import java.util.*;

/**
 * java8 获取多个map中的value
 *
 * @author baofei
 * @date 2018/5/22
 */
public class GetDuplicateMapValue {

	public static void main(String[] args) {
		new GetDuplicateMapValue().getDulicateMapValueNew();
	}

	private void getDulicateMapValue() {
		Map<String,List<String>> productTypeTree = new HashMap<>(5);
		List<String> l1 = Arrays.asList("a", "b");
		List<String> l2 = Arrays.asList("c", "d");
		List<String> l3 = Arrays.asList("e", "f");

		productTypeTree.put("1", l1);
		productTypeTree.put("2", l2);
		productTypeTree.put("3", l3);

		List<String> productCategoryOuts = new ArrayList<>();

		productTypeTree.forEach((str,list) -> productCategoryOuts.addAll(list));

		List<String> result = new ArrayList<>();
		productCategoryOuts.forEach(o -> result.add(o+"_"));

		result.forEach(System.out::println);
	}

	private void getDulicateMapValueNew() {
		Map<String,List<String>> productTypeTree = new HashMap<>(5);
		List<String> l1 = Arrays.asList("a", "b");
		List<String> l2 = Arrays.asList("c", "d");
		List<String> l3 = Arrays.asList("e", "f");

		productTypeTree.put("1", l1);
		productTypeTree.put("2", l2);
		productTypeTree.put("3", l3);

		List<String> result = new ArrayList<>();

		//1
		productTypeTree.forEach((str,list) -> list.forEach(p -> result.add(p+"_")));

		//2
		productTypeTree.values().forEach(o -> o.forEach(p -> result.add(p+"_")));

		result.forEach(System.out::println);
	}
}
