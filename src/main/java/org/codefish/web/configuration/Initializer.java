package org.codefish.web.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.codefish.spring.configuration.SpringMvcConfiguration;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Initialiser for the web application (replacement for web.xml file)
 * 
 * @author Matthew
 */
public class Initializer implements WebApplicationInitializer {
	public void onStartup(ServletContext ctx) throws ServletException {
		ctx.setInitParameter("contextConfigLocation", "/WEB-INF/spring/root-context.xml");
		
		AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
		servletContext.register(SpringMvcConfiguration.class);
		servletContext.setServletContext(ctx);
		servletContext.refresh();
		
		ServletRegistration.Dynamic appServlet = ctx.addServlet("dispatcher",new DispatcherServlet(servletContext));		
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");
		
		ctx.addListener(new ContextLoaderListener());
		
		
		
		// Filter mappings
		// - Spring security
		// Secures the application
		/**
		 * addMappingForUrlPatters() 
		 *  Parameters: 
		 * 
		 * dispatcherTypes - the dispatcher types of the filter
		 * mapping, or null if the default DispatcherType.REQUEST is to be used
		 * 
		 * isMatchAfter - true if the given filter mapping should be matched
		 * after any declared filter mappings, and false if it is supposed to be
		 * matched before any declared filter mappings of the ServletContext
		 * from which this FilterRegistration was obtained 
		 * 
		 * urlPatterns - the url
		 * patterns of the filter mapping
		 */
		ctx.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain")).addMappingForUrlPatterns(null, false, "/*");


		// - Sitemesh
		ctx.addFilter("sitemesh",new ConfigurableSiteMeshFilter()).addMappingForUrlPatterns(null, false, "/*");
	}
}
