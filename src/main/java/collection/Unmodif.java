package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Arctic
 */
public class Unmodif {

	public static void main(String[] args) {
		Collection<String> c = new ArrayList<>();
		Collection<String> s = Collections.unmodifiableCollection(c);
		c.add("str");
		System.out.println(s);
		s.add("str1");
	}
}
