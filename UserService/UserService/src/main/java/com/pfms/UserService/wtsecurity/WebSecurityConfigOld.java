/*
 * package com.pfms.UserService.wtsecurity;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.config.annotation.authentication.configuration.
 * AuthenticationConfiguration; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableGlobalMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.SecurityFilterChain; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter; import
 * org.springframework.web.cors.CorsConfiguration; import
 * org.springframework.web.cors.UrlBasedCorsConfigurationSource; import
 * org.springframework.web.filter.CorsFilter;
 * 
 * import com.pfms.UserService.service.UserService; import
 * com.pfms.UserService.wtsecurity.jwt.AuthEntryPointJwt; import
 * com.pfms.UserService.wtsecurity.jwt.AuthTokenFilter;
 * 
 * 
 * 
 * @Configuration
 * 
 * @EnableWebSecurity
 * 
 * @EnableGlobalMethodSecurity(prePostEnabled = true) public class
 * WebSecurityConfigOld {
 * 
 * @Autowired UserService userDetailsService;
 * 
 * @Autowired private AuthEntryPointJwt unauthorizedHandler;
 * 
 * @Bean public AuthTokenFilter authenticationJwtTokenFilter() { return new
 * AuthTokenFilter(); }
 * 
 * @Bean public AuthenticationManager
 * authenticationManager(AuthenticationConfiguration authConfig) throws
 * Exception { return authConfig.getAuthenticationManager(); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
 * throws Exception { http.cors().and().csrf().disable()
 * .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
 * and() .authorizeHttpRequests(auth -> auth
 * .requestMatchers("/api/auth/**").permitAll()
 * .requestMatchers("/api/user/**").permitAll()
 * .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**",
 * "/localhost:4200/**",
 * "/front-end-digitalbook.s3.us-east-1.amazonaws.com/**").permitAll()
 * .anyRequest().authenticated() ) .headers(headers ->
 * headers.frameOptions().sameOrigin());
 * 
 * http.addFilterBefore(authenticationJwtTokenFilter(),
 * UsernamePasswordAuthenticationFilter.class);
 * 
 * return http.build(); }
 * 
 * @Bean public CorsFilter corsFilter() { UrlBasedCorsConfigurationSource source
 * = new UrlBasedCorsConfigurationSource(); CorsConfiguration config = new
 * CorsConfiguration(); config.setAllowCredentials(true);
 * config.addAllowedOriginPattern("*"); // Use allowedOriginPatterns instead of
 * allowedOrigins config.addAllowedHeader("*"); config.addAllowedMethod("*");
 * source.registerCorsConfiguration("/**", config); return new
 * CorsFilter(source); } }
 */