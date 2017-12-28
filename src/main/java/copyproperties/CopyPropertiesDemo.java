package copyproperties;

import org.springframework.beans.BeanUtils;

/**
 * 接口
 *
 * @author baofei
 * @date 2017/12/28
 */
public class CopyPropertiesDemo {

	public static void main(String[] args) {
//		c1();
		c2();
	}

	private static void c2() {
		Source source = new Source();
		Target target = new Target();
		target.setValue("1");

		BeanUtils.copyProperties(source,target);

		System.out.println(source.getValue());
	}

	private static void c1() {
		Source source = new Source();
		source.setValue("1");
		Target target = new Target();

		BeanUtils.copyProperties(source,target);

		System.out.println(target.getValue());
	}
}
