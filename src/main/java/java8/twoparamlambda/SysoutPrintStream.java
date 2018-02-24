package java8.twoparamlambda;

import java.util.Map;

/**
 * 接口
 *
 * @author baofei
 * @date 2018/1/30
 */
public class SysoutPrintStream {

	public SysoutPrintStream() {
	}

	public void println(Map<Object, Object> map){
		map.entrySet().forEach(entry -> System.out.println(String.format("key:[%s] value[%s]%n",entry.getKey().toString(),entry.getValue())));
	}

}
