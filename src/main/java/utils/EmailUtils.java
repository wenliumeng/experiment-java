package utils;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ʼ���ع�����
 *
 * @author baofei
 * @date 2018/4/24
 */
public class EmailUtils {

	/**
	 * �ж��Ƿ�������
	 * @param email �����ַ���
	 * @return �Ƿ�������
	 */
	public static boolean isEmail(String email) {
		if (StringUtils.isEmpty(email)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ��������
	 * �Ȱ�ָ���ַ�(" ","��",",",)�ָ��ɵ������䣬�ٰѲ����Ϲ���������޳�
	 * @param originalEmail ԭʼ�����䴮
	 * @return �����б�
	 */
	public static List<String> filterEmail(String originalEmail) {
		List<String> result = new ArrayList<>();
		Collections.addAll(result,originalEmail.trim().replace(" ", "#").replace(",", "#").replace("��", "#").split("#"));

		Iterator<String> iterator = result.iterator();
		while(iterator.hasNext()){
			if (!isEmail(iterator.next())) {
				iterator.remove();
			}
		}
		return result;
	}
}
