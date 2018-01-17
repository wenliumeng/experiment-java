package java8;

/**
 * funciton demo
 *
 * @author baofei
 * @date 2017/12/14
 */
public class FunctionDemo {

	interface Convert<F, T> {
		T convert(F from);
	}

	static class Minteger {

		int value;

//		public Minteger() {}

		public Minteger(int from) {
			this.value = from;
		}

		static Minteger valueOf(String from){
			return new Minteger(Integer.valueOf(from));
		}
	}

	void staticMethod() {
		Convert<String, Integer> convert = Integer::valueOf;

		/*//原始写法
		Convert<String, Integer> convert1 = new Convert<String, Integer>() {
			@Override
			public Integer convert(String from) {
				return Integer.valueOf(from);
			}
		};*/

		//自定义
		Convert<String, Minteger> convert1 = Minteger::valueOf;

		Integer converted = convert.convert("123");
		System.out.println("converted  = " + converted);
		Minteger converted1 = convert1.convert("33");
		System.out.println("converted1 = " + converted1.value);
	}

	//::用在构造函数中的情况
	interface MintegerFactory<M extends Minteger> {
		M create(int value);
	}

	static class MintegerSub extends Minteger{

		int value;

		public MintegerSub(int from) {
			//必须显示的调用父类的构造方法
			super(from);
			this.value = from + 1;
		}

		static MintegerSub valueOf(String from){
			return new MintegerSub(Integer.valueOf(from));
		}
	}

	void constructor() {
		//使用Minteger::new来获取Minteger类构造参数的引用，java编译器会根据MintegerFactory.create的签名来选择合适的构造参数
		MintegerFactory<Minteger> factory = Minteger::new;
		System.out.println(factory.create(2).value);
		MintegerFactory<MintegerSub> factory1 = MintegerSub::new;
		System.out.println(factory1.create(2).value);
	}

	public static void main(String[] args) {
		new FunctionDemo().staticMethod();
		System.out.println();
		new FunctionDemo().constructor();
	}

}
