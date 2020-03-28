package cl.covid.service;

import cl.covid.client.rest.CovidClient;
import cl.covid.dto.CountriesStat;
import cl.covid.dto.CountriesStatResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CountryDasboardService {

    private CovidClient covidClient;

    public CountryDasboardService(CovidClient covidClient) {
        this.covidClient = covidClient;
    }

    public Mono<List<CountriesStat>> getCountriesData() {
        return this.covidClient.getCasesByCountry().map(CountriesStatResponse::getCountries_stat);
    }
}
