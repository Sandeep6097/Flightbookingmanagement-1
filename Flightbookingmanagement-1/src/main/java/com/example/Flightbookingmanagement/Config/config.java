package com.example.Flightbookingmanagement.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@SuppressWarnings({ "deprecation", "removal" })
@Configuration
@EnableWebSecurity
@Service
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class config extends WebSecurityConfigurerAdapter{

	@SuppressWarnings("unused")
	private static final String[] AUTH_WHITELIST = { // -- Swagger UI v2
			"/v2/api-Flightbookingmanagement", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
			"/configuration/security", "/swagger-ui.html", "/webjars/**",
			// -- Swagger UI v3 (OpenAPI)
			"/v3/api-Flightbookingmanagement/**", "/swagger-ui/**"
			// other public endpoints of your API may be appended to this array
	};
	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService); // //
		// .setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.authorizeRequests().antMatchers("/signup", "/login").permitAll().and().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/flight/**").permitAll().and().authorizeRequests()
		.antMatchers("/users/**").hasAnyAuthority("ADMIN").antMatchers("/flights/**").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.PUT, "/passengers/**").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/passengers/**").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.POST, "/passengers").hasAnyAuthority("USER").anyRequest().authenticated()
		.and().formLogin().permitAll().and().httpBasic();


	}

}
