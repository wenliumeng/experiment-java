package utils;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ���ݶ����ƹ���Map
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
		 * �ʼ�֪ͨͬ������
		 * 1="ͬ����Ʒ"
		 * 2="ͬ���ͻ�"
		 * 4="ͬ������"
		 * 8="ͬ�����"
		 * 16="ͬ���ʽ�"
		 * 32="ͬ������"
		 * optionValue��ֵΪ����������ֵ��ӣ�������Ҫ������Ʒ�Ϳͻ���ͬ�����󵽿ͻ����䣬��ô���ݿ���typeWarnEmail��optionValueΪ1+2=3��
		 */
		HashMap<String, String> tmp = new HashMap<>(6);
		tmp.put("1","ͬ����Ʒ");
		tmp.put("2","ͬ���ͻ�");
		tmp.put("4","ͬ������");
		tmp.put("8","ͬ�����");
		tmp.put("16","ͬ���ʽ�");
		tmp.put("32","ͬ������");


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
