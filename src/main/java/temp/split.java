package temp;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口
 *
 * @author bfei
 * @date 2018/9/5
 */
public class split {

	public static void split(String targetStr, int fromIndex, List<String> list) {

		int index = targetStr.indexOf("|", fromIndex);

		if (index != -1) {
			String unitNameString = targetStr.substring(fromIndex, index);
			list.add(unitNameString);
			split(targetStr, index + 1, list);
		} else {
			String unitNameString = targetStr.substring(fromIndex);
			list.add(unitNameString);
		}
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		split("123",0,list);
		System.out.println(list);
	}
}
