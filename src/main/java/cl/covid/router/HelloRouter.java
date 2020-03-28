package cl.covid.router;

import cl.covid.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class HelloRouter {

    private HelloHandler helloHandler;

    public HelloRouter(HelloHandler helloHandler) {
        this.helloHandler = helloHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> router() {
        return RouterFunctions.route(
                GET("/hello").and(accept(MediaType.APPLICATION_JSON)), helloHandler::hello
        );
    }
}
