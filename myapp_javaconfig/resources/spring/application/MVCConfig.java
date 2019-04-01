package spring.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/css/**")
		.addResourceLocations("/static/css/**")
		.setCachePeriod(60 * 60 * 24 * 365);
		
		registry.addResourceHandler("/fonts/**")
		.addResourceLocations("/static/fonts/**")
		.setCachePeriod(60 * 60 * 24 * 365);
		
		registry.addResourceHandler("/images/**")
		.addResourceLocations("/static/images/**")
		.setCachePeriod(60 * 60 * 24 * 365);
		
		registry.addResourceHandler("/js/**")
		.addResourceLocations("/static/js/**")
		.setCachePeriod(60 * 60 * 24 * 365);
		
		registry.addResourceHandler("/sass/**")
		.addResourceLocations("/static/sass/**")
		.setCachePeriod(60 * 60 * 24 * 365);
		
		registry.addResourceHandler("/publishing/**")
		.addResourceLocations("/static/publishing/**")
		.setCachePeriod(60 * 60 * 24 * 365);
	}
}
