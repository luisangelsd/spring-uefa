package com.miweb.app.practicaFifa22;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


public class ServletInitializer extends SpringBootServletInitializer{


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {	
		return builder.sources(PracticaFifa22JpaApplication.class);
	}
	
	
	

}
