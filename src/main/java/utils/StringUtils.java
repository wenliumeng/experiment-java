package utils;

import java.util.List;

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


	/**
	 * 按照分隔符分割成list
	 * @param targetStr 源字符串
	 * @param splitStr 分隔符
	 * @param fromIndex 分割开始的位置
	 * @param list 目标list
	 */
	public static void splitBarcode(String targetStr, String splitStr, int fromIndex, List<String> list) {
		if (org.springframework.util.StringUtils.isEmpty(targetStr) || org.springframework.util.StringUtils.isEmpty(splitStr)) {
			return;
		}

		int index = targetStr.indexOf(splitStr, fromIndex);

		if (index != -1) {
			String unitNameString = targetStr.substring(fromIndex, index);
			list.add(unitNameString);
			splitBarcode(targetStr, splitStr, index + 1, list);
		} else {
			String unitNameString = targetStr.substring(fromIndex);
			list.add(unitNameString);
		}
	}
}
