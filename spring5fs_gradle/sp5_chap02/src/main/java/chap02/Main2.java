package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
	
	private Greeter g3;
	
	//생성자를 통한 주입.
	public void setMethod(Greeter g) {
		this.g3 = g;
	}
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println("(g1 == g2) = " + (g1 == g2));
		ctx.close();
		//결과값은 true. 같은 객체를 리턴하는 것을 의미한다.
	}
}
