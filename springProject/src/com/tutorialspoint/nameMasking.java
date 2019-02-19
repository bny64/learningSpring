package com.tutorialspoint;
import java.util.ArrayList;
import java.util.List;

public class nameMasking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(method1("김숙"));
		System.out.println(method1("이순신"));
		System.out.println(method1("신사임당"));
		System.out.println(method1("로버트할리"));
		System.out.println(method2("김숙"));
		System.out.println(method2("이순신"));
		System.out.println(method2("신사임당"));
		System.out.println(method2("로버트할리"));
	}

	public static String method1(String name) {
		String realName = "";
		List<Character> userName = new ArrayList<Character>();
		
		for(int i=0; i<name.length(); i++) {
			char element = name.charAt(i);
			userName.add(element);
		}
		
		if(userName.size()<4) {
			userName.set(1, "*".charAt(0));
		}else {
			for(int i=1; i<userName.size()-1; i++) {
				userName.set(i, "*".charAt(0));
			}
		}
		
		for(Character element : userName) {
			realName += element;
		}
		return realName;
	}
	
	public static String method2(String name) {
		String realName = "";
		
		if(name.length()<3) {
			realName = name.substring(0, 1) + "*";
		}else if(name.length()<4) {
			realName = name.substring(0, 1) + "*" + name.substring(name.length()-1, name.length());
		}else {
			String masking = "";
			for(int i=0; i<name.length()-2; i++) {
				masking += "*";
			}
			realName = name.substring(0, 1) + masking + name.substring(name.length()-1, name.length());
		}
		
		return realName;
	}
	
}
