package cl.covid.dto;


import lombok.Data;

@Data
public class CountriesStat {
    public String country_name;
    public String cases;
    public String deaths;
    public String region;
    public String total_recovered;
    public String new_deaths;
    public String new_cases;
    public String serious_critical;
    public String active_cases;
    public String total_cases_per_1m_population;
}
