package com.example.application.endpoints;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.example.application.backend.SensorData;
import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Endpoint
@AnonymousAllowed
public class Sensors {
  private final RestTemplate restTemplate = new RestTemplate();
  
  @Value("${4apis.api.key:}")
  private String apiKey;

  public Sensors() {
    // Custom configuration to use Jackson despite the text/plain response type
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN));
    restTemplate.setMessageConverters(Arrays.asList(converter));
  }

  @PostConstruct
  private void validateKey() {
    if (apiKey == null || apiKey.trim().isEmpty()) {
      throw new IllegalStateException("You must define 4apis.api.key in application.properties: " + apiKey);
    }
  }

  public SensorData[] getSensorReadings(String locationId) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Ocp-Apim-Subscription-Key", apiKey);
    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
    
    ResponseEntity<SensorData[]> result = restTemplate.exchange("https://businessfinland-4apis.azure-api.net/api/measurements/{locationId}", HttpMethod.GET, entity, SensorData[].class, locationId);

    return result.getBody();
  }
}