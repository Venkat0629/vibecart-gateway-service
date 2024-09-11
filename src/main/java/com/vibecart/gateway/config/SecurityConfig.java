//package com.vibecart.gateway.config;
//
//import com.nisum.vibe.cart.offers.repository.AccountRepository;
//import com.nisum.vibe.cart.offers.service.AccountUserDetailsService;
//import com.vibecart.gateway.filter.JwtAuthFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private JwtAuthFilter authFilter;
////    private AccountRepository accountRepository;
//
//    public SecurityConfig(JwtAuthFilter authFilter, AccountRepository accountRepository) {
//        this.authFilter = authFilter;
//        this.accountRepository = accountRepository;
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new AccountUserDetailsService(accountRepository);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.cors().configurationSource(corsConfigurationSource()).and()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/v1/vibe-cart/offers", "/api/v1/vibe-cart/offers/{id}", "/api/v1/vibe-cart/offers/item/{id}", "/api/v1/vibe-cart/offers/sku/{id}", "/api/v1/vibe-cart/offers/coupon/{code}").permitAll()
//                .antMatchers("/api-docs", "/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/v1/vibe-cart/offers/login", "/api/v1/vibe-cart/offers/account").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/v1/vibe-cart/offers").hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/api/v1/vibe-cart/offers/{id}").hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/v1/vibe-cart/offers").hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.PATCH, "/api/v1/vibe-cart/offers{id}").hasAnyRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH"));
//        configuration.setAllowedHeaders(Collections.singletonList("*"));
//        configuration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//
//
//}
