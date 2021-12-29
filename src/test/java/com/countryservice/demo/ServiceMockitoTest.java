package com.countryservice.demo;

import com.countryservice.demo.beans.Country;
import com.countryservice.demo.repositories.CountryRepository;
import com.countryservice.demo.services.CountryService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = {ServiceMockitoTest.class})
public class ServiceMockitoTest {
    @Mock
    CountryRepository countryrep;

    @InjectMocks
    CountryService countryService;
    public List<Country> mycountries;
    @Test
    @Order(1)
    public void test_getAllCountries() {
        List<Country> mycountries=new ArrayList<Country>();
        mycountries.add(new Country(1,"India","Delhi"));
        mycountries.add(new Country(2,"USA","Washington"));
        when(countryrep.findAll()).thenReturn(mycountries);
         assertEquals(2,countryService.getAllCountries().size());
    }

}
