package java8;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 接口
 *
 * @author bfei
 * @date 2018/9/18
 */
public class StreamFilterNull {

	public static void main(String[] args) {
		Student s1 = new Student("1","zhang");
		Student s2 = new Student("2","wang");
		Student s3 = new Student("3","zhao");

		List<Student> unitPrices = Lists.newArrayList(s1,s2,s3);

		Student s4 = new Student("4", "");
		unitPrices.stream().filter(u -> u.getId().equals("5")).findFirst().ifPresent(s -> s4.setName(s.getName()));

		System.out.println(s4.getId() +"  " + s4.getName());
	}
}