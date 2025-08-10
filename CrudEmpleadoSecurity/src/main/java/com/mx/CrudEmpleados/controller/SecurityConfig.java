package com.mx.CrudEmpleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mx.CrudEmpleados.UserDetailsService.detalleUsuarios;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	detalleUsuarios detalleServicioUsuario;
	
	/**Permite encriptar frases o palabras
	 * 
	 * Es una función porque tiene un valor de retorno 
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	Una forma de hacerlo
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		{
			auth.userDetailsService(detalleServicioUsuario).passwordEncoder(passwordEncoder());
		}
	}
	
//	public void configure(AuthenticationManagerBuilder auth) throws Exception{
//		{
//			auth
//			.inMemoryAuthentication()
//			.withUser("ADMIN")
//			.password("12345")
//			.and()
//			.withUser("user")
//			.password("12345")
//			.roles("ADMIN","user");
//			
//			auth.userDetailsService(detalleServicioUsuario).passwordEncoder(passwordEnconder());
//		}
//	}
	
//	public void configure(HttpSecurity http) throws Exception{
//		http
//		.authorizeHttpRequests()
//		.anyRequest()
//		.authenticated()
//		.and()
//		.httpBasic();
//	}
}
