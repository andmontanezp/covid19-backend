package cl.covid.client.rest;

import cl.covid.dto.CountriesStatResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.TEXT_HTML;

@Component
public class CovidClient {
    public Mono<CountriesStatResponse> getCasesByCountry() {
        return WebClient.builder()
                .baseUrl("https://coronavirus-monitor.p.rapidapi.com/coronavirus/cases_by_country.php")
                .exchangeStrategies(ExchangeStrategies.builder().codecs(this::acceptedCodecs).build())
                .build()
                .get()
                .header("x-rapidapi-key", "6ba6c4c858mshbf724ce2added94p1212b0jsn4960de35eefa")
                .retrieve()
                .bodyToMono(CountriesStatResponse.class);
    }

    private void acceptedCodecs(ClientCodecConfigurer clientCodecConfigurer) {
        clientCodecConfigurer.customCodecs().encoder(new Jackson2JsonEncoder(new ObjectMapper(), TEXT_HTML));
        clientCodecConfigurer.customCodecs().decoder(new Jackson2JsonDecoder(new ObjectMapper(), TEXT_HTML));
    }
}


