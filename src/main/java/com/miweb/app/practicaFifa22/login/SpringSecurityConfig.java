package com.miweb.app.practicaFifa22.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Bean //Creamos una dependencia de BCryptPasswordEncoder
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

		
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{		
		//Esta configuración encrita todas las contraseñas
		PasswordEncoder encoder= passwordEncoder(); 
		UserBuilder users=User.builder().passwordEncoder(encoder::encode);
		
		
		//Esta configuración nos permite crear clientes		
		builder.inMemoryAuthentication() 
		.withUser(users.username("admin1").password("123").roles("ADMIN"))
		.withUser(users.username("user1").password("123").roles("USER"));
	}


	
	@Autowired
	public LoginSuccessHandlerConfig loginSuccessHandlerConfig;
	
	@Autowired
	public LoginFailHandlerConfig loginFailHandlerConfig;
	
	@Override //Configuramos las rutas de acceso a los usuarios y accesi al Login/Logout
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/","/css/**","/js/**").permitAll()
		.antMatchers("/agregar-equipo/**").hasAnyRole("ADMIN","USER")
		.antMatchers("/eliminar/**").hasAnyRole("ADMIN")
		.antMatchers("/editar/**").hasAnyRole("ADMIN","USER")
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.successHandler(loginSuccessHandlerConfig)
			.failureHandler(loginFailHandlerConfig)
			.loginPage("/login").permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
	}	
	

}//class
