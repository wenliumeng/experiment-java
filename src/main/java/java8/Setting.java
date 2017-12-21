package java8;

import java.util.Arrays;
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

		R operate(T t, R r);

	}

	/**
	 * 函数接口Function<T,R>的定义仅仅代表了出入参的类型,针对Function的apply来说，就是入参类型T,出参类型R
	 * 在函数接口中定义的唯一方法才是接口正真操作的内容
	 */
	protected Function<Integer, String> defaultValue;
	protected MFunction<Integer, String> defaultValue1;
	protected Function<Integer, T> defaultValue2;
	protected Function<Integer, String[]> defaultValue3;

	/*public Setting(Function<Integer, String> defaultValue) {
		this.defaultValue = defaultValue;
	}*/

	public Setting(Function<Integer, T> defaultValue) {
		this.defaultValue2 = defaultValue;
	}

	public Setting(MFunction<Integer, String> defaultValue) {
		this.defaultValue1 = defaultValue;
	}

	public Setting(String defaultValue) {
		//形如s -> "",就是基本的赋值操作，但是这种没用用到参数s的函数就是抛弃了Function的参数Integer(apply方法接收的参数)
		//使用Function<Integer, String> defaultValue;
//		this((s) -> defaultValue);

		//这一步确定了apply的函数操作，定义的s是Function<T,R>中的T,main函数中调用的apply的参数也是T,只是返回值是R
//		this(s -> defaultValue + s.doubleValue());
//		this(s -> String.valueOf(Math.max(s,defaultValue.length())));

		//MFunction 两个参数
//		this((Integer s, String v) -> s.toString() + v);

		//<editor-fold desc="采用构造方法Setting(Function<Integer, T> defaultValue)">
		//使用Function<Integer, T> defaultValue2
		// TODO: 2017/12/21 为什么不能在这个地方使用test()中的逻辑，没有定义T的类型。构造方法中就不能确定T的类型
		/*this((s) -> {
			String resultP1 = s + "1";
			String resultP2 = s + "2";
			String results[] = new String[]{resultP1, resultP2, resultP1};
			return results;
		});*/

		// TODO: 2017/12/21 String类型的defaultValue关联到函数Function<String,T>
		defaultValue3 = (s) -> {
			String resultP1 = s + "1";
			String resultP2 = s + "2";
			String results[] = new String[]{resultP1, resultP2, resultP1,defaultValue};
			return results;
		};
//		this(new Function<Integer, T>() {
//			@Override
//			public T apply(Integer integer) {
//				System.out.println("sout " + defaultValue);
//				return null;
//			}
//		});
		//</editor-fold>
	}

	public static Setting<String[]> test() {
		return new Setting<>((s) -> {
			String resultP1 = s + "1";
			String resultP2 = s + "2";
			String results[] = new String[]{resultP1, resultP2, resultP1};
			return results;
		});
	}

	public static void main(String[] args) {
		/*Setting<String> demo = new Setting<>("df");
		String result = demo.defaultValue1.operate(8,"ii");
		System.out.println(result);*/

		/*Setting<String> demo = new Setting<>("操作入参");
		String result = demo.defaultValue.apply(8);
		System.out.println(result);*/

		Setting<String[]> testResult = Setting.test();
		System.out.println(Arrays.asList(testResult.defaultValue2.apply(8)));
	}

}
