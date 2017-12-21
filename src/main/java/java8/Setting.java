package java8;

import java.util.function.Function;

/**
 * settings function demo
 *
 * @author baofei
 * @date 2017/12/15
 */
public class Setting<T> {

	@FunctionalInterface
	interface MFunction<T, R> {

		R operate(T t,R r);

	}

	/**
	 * 函数接口Function<T,R>的定义仅仅代表了出入参的类型,针对Function的apply来说，就是入参类型T,出参类型R
	 * 在函数接口中定义的唯一方法才是接口正真操作的内容
	 */
	protected Function<Integer, String> defaultValue;
	protected MFunction<Integer, String> defaultValue1;

	public Setting(Function<Integer, String> defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Setting(MFunction<Integer, String> defaultValue) {
		this.defaultValue1 = defaultValue;
	}

	public Setting(String defaultValue) {
		//形如s -> "",就是基本的赋值操作
		//这一步确定了apply的函数操作，定义的s就是apply的参数
//		this(s -> defaultValue + s);


		this(s -> String.valueOf(Math.max(s,defaultValue.length())));

		//MFunction 两个参数
//		this((Integer s, String v) -> s.toString() + v);
	}

	public static void main(String[] args) {
		/*Setting<String> demo = new Setting<>("df");
		String result = demo.defaultValue1.operate(8,"ii");
		System.out.println(result);*/

		Setting<String> demo = new Setting<>("操作入参");
		String result = demo.defaultValue.apply(8);
		System.out.println(result);


	}

}
