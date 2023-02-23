package com.miweb.app.practicaFifa22.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@Component
public class LoginSuccessHandlerConfig extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		SessionFlashMapManager flashManager=new SessionFlashMapManager();
		FlashMap flashMap=new FlashMap();
		flashMap.put("success", "Que alegría verte de nuevo "+authentication.getName()+".");
		flashManager.saveOutputFlashMap(flashMap, request, response);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

	
	
	
}
