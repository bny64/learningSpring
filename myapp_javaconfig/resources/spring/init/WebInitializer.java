package spring.init;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import spring.root.RootConfig;

//web.xml이 정의되어 있지 않으면 WebApplicationInitializer을 먼저 찾음.
public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
			
		//스프링 환경설정
		AnnotationConfigWebApplicationContext springConfig = new AnnotationConfigWebApplicationContext();
		springConfig.scan("spring.application");
		
		container.addListener(new ContextLoaderListener(springConfig));
		
		//루트 설정
		AnnotationConfigWebApplicationContext rootConfig = new AnnotationConfigWebApplicationContext();
		springConfig.register(RootConfig.class);		
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootConfig));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		FilterRegistration charEncodingFilterReg = container.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
		
		charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
		//charEncodingFilterReg.setInitParameter("forceEncoding", "true");
	}
	
}
