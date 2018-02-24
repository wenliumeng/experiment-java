package java8.twoparamlambda;

import java.util.Map;

/**
 * 接口
 *
 * @author baofei
 * @date 2018/1/30
 */
public class Sysout {

	public final static SysoutPrintStream out = new SysoutPrintStream();

	static class SysoutPrintStream1 {
		public SysoutPrintStream1() {
		}
		public void println(Map<Object, Object> map){
			map.entrySet().forEach(entry -> System.out.println(String.format("key:[%s] value[%s]%n",entry.getKey().toString(),entry.getValue())));
		}
	}

}
