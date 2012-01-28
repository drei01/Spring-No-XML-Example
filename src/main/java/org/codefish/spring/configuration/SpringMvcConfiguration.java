package org.codefish.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Main MVC application and servlet configuration
 * @author Matthew
 *
 */
@Configuration
@Import(value=SpringMongoConfig.class)
@EnableWebMvc
@ComponentScan(basePackages="org.codefish.blog.controller")//scan for controllers
public class SpringMvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Bean
    public DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping() {
		return new DefaultAnnotationHandlerMapping();
    }

	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void configureResourceHandling(ResourceConfigurer configurer) {
		super.configureResourceHandling(configurer);
		configurer.addPathMapping("resources/**");
		configurer.addResourceLocation("resources/");
		configurer.setCachePeriod(31556926);
	}
	
	@Bean
	public SimpleMappingExceptionResolver exceptionResolver() throws Exception {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		exceptionResolver.setWarnLogCategory("SimpleExceptionResolver");
		exceptionResolver.setDefaultErrorView("uncaught-error");
		return exceptionResolver;
	}
}
