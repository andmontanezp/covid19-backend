package cl.covid.dto;

import lombok.Data;

import java.util.List;

@Data
public class CountriesStatResponse {
    private List<CountriesStat> countries_stat;
    private String statistic_taken_at;
}
