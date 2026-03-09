package in.cg.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    	 http
         .csrf(csrf -> csrf.disable())
         .authorizeHttpRequests(auth -> auth
                 .requestMatchers("/api/users/register").permitAll()
                 .requestMatchers("/login", "/logout").permitAll()
                 .requestMatchers("/swagger-ui/*", "/v3/api-docs/*").permitAll()
                 .anyRequest().authenticated()
         )
         .formLogin(form -> form
                 .loginProcessingUrl("/login")
                 .successHandler((req, res, auth) -> res.setStatus(200))
         )
         .logout(logout -> logout.logoutUrl("/logout"));

          

        return http.build();
    }
}