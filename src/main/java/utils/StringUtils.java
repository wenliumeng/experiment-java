package utils;

public class StringUtils {

	/**
	 * 在数字型字符串千分位加逗号
	 * @param str
	 * @return
	 */
	public static String addComma(String str){
		boolean neg = false;
		//处理负数
		if (str.startsWith("-")){
			str = str.substring(1);
			neg = true;
		}
		String tail = null;
		//处理小数点
		if (str.indexOf('.') != -1){
			tail = str.substring(str.indexOf('.'));
			str = str.substring(0, str.indexOf('.'));
		}
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		for (int i = 3; i < sb.length(); i += 4){
			sb.insert(i, ',');
		}
		sb.reverse();
		if (neg){
			sb.insert(0, '-');
		}
		if (tail != null){
			sb.append(tail);
		}
		return sb.toString();
	}
}
