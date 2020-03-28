package cl.covid.handler;

import cl.covid.dto.CountriesStat;
import cl.covid.service.CountryDasboardService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class DashboardHandler {
    private CountryDasboardService countryDasboardService;

    public DashboardHandler(CountryDasboardService countryDasboardService) {
        this.countryDasboardService = countryDasboardService;
    }

    public Mono<ServerResponse> getDataByCountry(ServerRequest request) {
        Mono<List<CountriesStat>> data = this.countryDasboardService.getCountriesData();
        return data.flatMap(d -> ServerResponse.ok()
                            .contentType(APPLICATION_JSON)
                            .body(BodyInserters.fromValue(d))
        );
    }
}
