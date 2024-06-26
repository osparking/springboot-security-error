package space.bum.spring_boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//  @Bean
//  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.authorizeHttpRequests(
//        expressionInterceptUrlRegistry -> expressionInterceptUrlRegistry
//            .anyRequest()
//            .permitAll())
//        .csrf(AbstractHttpConfigurer::disable);
//    return http.build();
//  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth)
      throws Exception {
    auth
        .inMemoryAuthentication()
        .withUser("user").password(passwordEncoder().encode("password"))
        .roles("USER")
        .and()
        .withUser("admin").password(passwordEncoder().encode("admin"))
        .roles("ADMIN");
  }

  @Bean
  static BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
