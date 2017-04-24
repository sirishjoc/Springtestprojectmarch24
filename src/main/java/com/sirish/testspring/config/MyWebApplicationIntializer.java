package com.sirish.testspring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationIntializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		
		// Create the 'root' Spring application context
		rootContext.setConfigLocation("com.sirish.testspring.config");
		rootContext.register(AppConfig.class);
		container.addListener(new ContextLoaderListener(rootContext));
		
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		
		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet(
				"dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setInitParameter("dispatchOptionsRequest", "true");
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/*");
		
		rootContext.close();
		dispatcherContext.close();
	}

}
