package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		//자바 설정 정보를 가져와 빈 객체를 생성하고 관리한다.
		//AppContext에 정의한 @Bean 설정정보를 읽어와 Greeter 객체를 생성하고 초기화한다.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		//getBean() 메서드는 자바 설정을 읽어와 생성한 빈 객체를 검색할 때 사용한다.
		//@Bean 메서드의 이름이 "greeter"이고 생성한 객체의 리턴 타입이 Greeter 이므로 
		//Greeter 객체를 리턴한다.
		Greeter g = ctx.getBean("greeter", Greeter.class);
		
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();
	}
}
