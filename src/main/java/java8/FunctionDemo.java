package java8;

import java.util.function.Function;

/**
 * funciton demo
 *
 * @author baofei
 * @date 2017/12/14
 */
public class FunctionDemo {

	static String modifyTheValue(String str, Function<String, String> function){
		return function.apply(str);
	}

	public static void main(String[] args) {
		System.out.println(modifyTheValue("00", val -> val + "1"));
	}
}
