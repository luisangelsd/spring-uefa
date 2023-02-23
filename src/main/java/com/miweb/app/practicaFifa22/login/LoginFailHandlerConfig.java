package com.miweb.app.practicaFifa22.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@Component
public class LoginFailHandlerConfig extends SimpleUrlAuthenticationFailureHandler{

	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		SessionFlashMapManager flashManager=new SessionFlashMapManager();
		FlashMap flashMap=new FlashMap();
		flashMap.put("error", "Error en el usuario o contraseña");
		flashManager.saveOutputFlashMap(flashMap, request, response);
		
		super.onAuthenticationFailure(request, response, exception);
	}
	
	

}
