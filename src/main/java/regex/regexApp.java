package regex;

import java.util.ArrayList;
import java.util.List;

public class regexApp {

	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>();
		l1.add("121");
		List<String> l2 = new ArrayList<>();
		String e = l1.get(0);
		l2.add(e);
		l2.forEach(o -> o.replace("2","-"));
		System.out.println(e);


	}

}
