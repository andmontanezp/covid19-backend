package cl.covid.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class HelloHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {
        Mono<String> mono = Mono.just("Hello !!");
        return ServerResponse.ok().body(mono, String.class);
    }
}
