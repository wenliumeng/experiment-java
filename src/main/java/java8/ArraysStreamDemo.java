package java8;

import org.springframework.util.AntPathMatcher;

import java.util.Arrays;

public class ArraysStreamDemo {

	public static void main(String[] args) {
		String[] endpoints = {"123", "sd"};
		String url = "123";
		AntPathMatcher matcher = new AntPathMatcher();
		System.out.println(Arrays.stream(endpoints).anyMatch(e -> matcher.match(e, url)));
	}
}
