package java8;

/**
 * 函数式接口
 *
 * @author Arctic
 * @date 2017/12/18
 */
public class FuntionDemo1 {

	@FunctionalInterface
	public interface Operate<T,R> {

		/**
		 * 函数式接口只能包含一个抽象方法，但因为默认方法不算抽象方法，所以可以有默认方法
		 * @param t 参数
		 * @param r 参数
		 * @return 操作结果
		 */
		int accept(T t,R r);
	}

	private static class Minteger {

		int param;

		public Minteger(int param) {
			this.param = param;
		}

		public static int sub(Minteger a, Minteger b) {
			Operate<Integer,Integer> operate = Integer::max;
			Operate<Integer,Integer> operate1 = Integer::min;
			return operate.accept(a.toInt(),b.toInt()) - operate1.accept(a.toInt(),b.toInt());
		}

		private int toInt() {
			return param;
		}

	}

	private int doAddMethod(int a, int b) {
		Operate<Integer,Integer> addResult = new Operate<Integer, Integer>() {
			@Override
			public int accept(Integer integer, Integer integer2) {
				return integer + integer2;
			}
		};
		return addResult.accept(a, b);
	}

	private int doSubMethod(int a, int b) {
		Operate<Integer,Integer> subResult = (v,m) -> v - m;
		return subResult.accept(a, b);
	}

	private int doSubMethodM(int a, int b) {
		Operate<Minteger,Minteger> subResult = Minteger::sub;
		return subResult.accept(new Minteger(a),new Minteger(b));
	}

	private int doSubMethodM1(int a, int b) {
		Operate<Minteger,Minteger> subResult = (v, m)->Minteger.sub(v,m);
		return subResult.accept(new Minteger(a),new Minteger(b));
	}

	private int doSubMethodM2(int a, int b) {
		return ((Operate<Minteger,Minteger>)Minteger::sub).accept(new Minteger(a),new Minteger(b));
	}

	//直接能跳过函数表达式？
	private int doSubMethodM3(int a, int b) {
		return Minteger.sub(new Minteger(a), new Minteger(b));
	}

	//构造一个方法参数接收function类型的参数,开源项目的调用方式
	//参数为"Integer::max",如果过用doSubMethodM3()中的方式，操作方式就不能当错参数传到方法中
	private void methodParamFunction(Operate<Integer,Integer> operate,int a,int b) {
		System.out.println(operate.accept(a, b));
	}

	public static void main(String[] args) {
		FuntionDemo1 demo = new FuntionDemo1();
		System.out.println(demo.doAddMethod(1, 7));
		System.out.println(demo.doSubMethod(5, 1));
		System.out.println(demo.doSubMethodM3(3, 4));
		System.out.println(demo.doSubMethodM3(3, 4));
		System.out.println(demo.doSubMethodM3(3, 4));
		System.out.println(demo.doSubMethodM(3, 4));
		System.out.println();
		System.out.println("开源项目中的调用方式");
		demo.methodParamFunction(Integer::max,3,1);
	}
}


