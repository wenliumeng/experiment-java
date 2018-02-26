package java8.twoparamlambda;

/**
 * 两个参数的lambdaDemo
 *
 * @author baofei
 * @date 2018/1/31
 */
public class Main {

	public static void main(String[] args) {
		System.out.println(new Main().c());
	}

	boolean c(){
		int i = 0;
		for(;;){
			i++;
			System.out.println(i);
			if (i == 10){
				return false;
			}
		}
	}
}
