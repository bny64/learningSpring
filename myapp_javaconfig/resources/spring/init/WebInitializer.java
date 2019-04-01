package spring.init;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import spring.root.RootConfig;

//web.xml이 정의되어 있지 않으면 WebApplicationInitializer을 먼저 찾음.
public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		//스프링 환경설정
		WebApplicationContext applicationContext = getContext("spring.application");
		container.addListener(new ContextLoaderListener(applicationContext));
		
		//dispatcher servlet 설정
		WebApplicationContext rootContext = getContext("spring.root");
		setupDispatcherServlet(container, rootContext);
		
		FilterRegistration charEncodingFilterReg = container.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
		
		charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
		//charEncodingFilterReg.setInitParameter("forceEncoding", "true");
	}
	
	private void setupDispatcherServlet(ServletContext servletContext, WebApplicationContext context) {
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet",  new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
	
	private AnnotationConfigWebApplicationContext getContext(String path) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		//context.setConfigLocation("spring.application"); //경로
		//context.register(RootConfig.class) //클래스 이름.
		context.scan(path);
		return context;
	}
	
}
