package utils;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 邮件相关工具类
 *
 * @author baofei
 * @date 2018/4/24
 */
public class EmailUtils {

	/**
	 * 判断是否是邮箱
	 * @param email 邮箱字符串
	 * @return 是否是邮箱
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
	 * 过滤邮箱
	 * 先按指定字符(" ","，",",",)分隔成单个邮箱，再把不符合规则的邮箱剔除
	 * @param originalEmail 原始多邮箱串
	 * @return 邮箱列表
	 */
	public static List<String> filterEmail(String originalEmail) {
		List<String> result = new ArrayList<>();
		Collections.addAll(result,originalEmail.trim().replace(" ", "#").replace(",", "#").replace("，", "#").split("#"));

		Iterator<String> iterator = result.iterator();
		while(iterator.hasNext()){
			if (!isEmail(iterator.next())) {
				iterator.remove();
			}
		}
		return result;
	}
}
