package com.ev.microservices.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                //ALLOWING REGISTER API FOR DIRECT ACCESS
                .pathMatchers("/chargingstation/available").permitAll()
                //ALL OTHER APIS ARE AUTHENTICATED
                .anyExchange().authenticated()
                .and()
                .csrf().disable()
                .oauth2Login()
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }

    /*@Bean
    @Primary
    @ConditionalOnProperty(name = {
            "spring.security.oauth2.resourceserver.jwt.jwk-set-uri",
            "spring.security.oauth2.resourceserver.jwt.useInsecureTrustManager"
    })
    ReactiveJwtDecoder insecureJwtDecoder(OAuth2ResourceServerProperties properties) {
        var jwtDecoder = NimbusReactiveJwtDecoder
                .withJwkSetUri(properties.getJwt().getJwkSetUri())
                .jwsAlgorithms(algorithms -> algorithms.add(SignatureAlgorithm.from("RS256")))
                .webClient(InsecureWebClient.getInstance())
                .build();
        jwtDecoder.setJwtValidator(JwtValidators.createDefault());
        return jwtDecoder;
    }

    public class InsecureWebClient {
        @SneakyThrows
        public static WebClient getInstance() {
            var sslContext = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
            var httpClient = HttpClient.create().secure(b -> b.sslContext(sslContext));
            return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();
        }
    }*/

}
