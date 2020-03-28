package cl.covid.router;

import cl.covid.handler.DashboardHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CountriesRouter {
    private DashboardHandler dashboardHandler;

    public CountriesRouter(DashboardHandler dashboardHandler) {
        this.dashboardHandler = dashboardHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> countries() {
        return RouterFunctions.route(
                GET("/dashboard").and(accept(MediaType.APPLICATION_JSON)), dashboardHandler::getDataByCountry
        );
    }
}
