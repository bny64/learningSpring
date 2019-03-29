package spring.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import spring.root.RootConfig;

public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
				
		AnnotationConfigWebApplicationContext springConfig = new AnnotationConfigWebApplicationContext();
		springConfig.scan("spring.application");
		
		container.addListener(new ContextLoaderListener(springConfig));
		
		AnnotationConfigWebApplicationContext rootConfig = new AnnotationConfigWebApplicationContext();
		springConfig.register(RootConfig.class);		
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootConfig));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	}
	
}
