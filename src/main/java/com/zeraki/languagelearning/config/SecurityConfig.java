package com.zeraki.languagelearning.config;

import com.zeraki.languagelearning.security.JwtAuthenticationFilter;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.zeraki.languagelearning.security.JwtAuthenticationEntryPoint;



@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint point;
    
    @Autowired
    private JwtAuthenticationFilter filter;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests()
                .requestMatchers("/api-docs/**").permitAll()
                .requestMatchers("/api-docs").permitAll()
                .requestMatchers("/v3/api-docs/**").permitAll()
                .requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/auth/login").permitAll()
                .requestMatchers("/auth/create-user").permitAll()
                .anyRequest()
                .authenticated()
                .and().
                
                
                exceptionHandling(ex -> ex.authenticationEntryPoint(point))

                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider doDaoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
       provider.setUserDetailsService(userDetailsService);
       provider.setPasswordEncoder(passwordEncoder);
       return provider;
    }
    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().
                        addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes
                        ("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info().title("Zeraki API")
                        .description("RESTful API for a language learning module of an online system. The API will manage lessons, and exercises, and track user progress")
                        .version("1.0").contact(new Contact().name("Paul Obiero")
                                .email( "paulobiero147@gmail.com").url("paulobiero147@gmail.com"))
                        .license(new License().name("License of API")
                                .url("API license URL")));
    }
}
