package com.project.store.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.project.store.handler.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class securityConfiguration {

    @Autowired
    private UserDetailsService userDetailsService;

    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/pages/inventary/**", "/pages/soldProducts/**", "register/**")
                .hasRole("ADMIN")
                .requestMatchers("/pages/addInventary/**","statics/**", "/pages/main/**")
                .hasAnyRole("VENDEDOR","ADMIN")
                .anyRequest()
                .permitAll())
                .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .successForwardUrl("/home")
                .failureUrl("/login?error")
                .successHandler(new LoginSuccessHandler())
                .permitAll())
                .logout(logout -> logout
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll())
                .exceptionHandling(exeptions -> exeptions
                .accessDeniedPage("/errors/error404"));
        return http.build();
    }
}
