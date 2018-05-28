package utils;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 根据二进制过滤Map
 *
 * @author bfei
 * @date 2018/5/28
 */
public class FilterMapForBinary {

	public static void main(String[] args) {
		Arrays.asList(new FilterMapForBinary().filterMap(8)).forEach(System.out::println);
	}

	private Object[] filterMap(int param) {
		Integer value = param;
		/**
		 * 邮件通知同步类型
		 * 1="同步商品"
		 * 2="同步客户"
		 * 4="同步订单"
		 * 8="同步库存"
		 * 16="同步资金"
		 * 32="同步物流"
		 * optionValue的值为，以上任意值相加，比如需要发送商品和客户的同步错误到客户邮箱，那么数据库中typeWarnEmail的optionValue为1+2=3。
		 */
		HashMap<String, String> tmp = new HashMap<>(6);
		tmp.put("1","同步商品");
		tmp.put("2","同步客户");
		tmp.put("4","同步订单");
		tmp.put("8","同步库存");
		tmp.put("16","同步资金");
		tmp.put("32","同步物流");


		final int size = tmp.size();
		StringBuilder toBinaryString = new StringBuilder(Integer.toBinaryString(value));
		while (toBinaryString.length() < size){
			toBinaryString.insert(0,"0");
		}
		for (int i = size; i > 0; i--) {
			if ("0".equals(toBinaryString.substring(i - 1, i))) {
				tmp.remove((int) Math.pow(2, size - i) + "");
			}
		}
		return tmp.values().toArray();
	}
}
