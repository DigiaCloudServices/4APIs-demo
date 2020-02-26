package com.example.application.endpoints;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.example.application.backend.SensorData;
import com.vaadin.flow.server.connect.Endpoint;
import com.vaadin.flow.server.connect.auth.AnonymousAllowed;

@Endpoint
@AnonymousAllowed
public class Sensors {
  public List<SensorData> getSensorReadings(@Nullable String locationId) {
    ArrayList<SensorData> readings = new ArrayList<>();

    if (locationId == null || "2105".equals(locationId)) {
        SensorData reading1 = new SensorData();
        reading1.setSiteId("Ypsilon");
        reading1.setLocationId("2105");
        reading1.setSensorCategory("Exhaust air");
        reading1.setSensorAttribute("Temperature");
        reading1.setUnit("°C");
        reading1.setTime(LocalDateTime.of(2020, Month.JANUARY, 28, 13, 30).atZone(ZoneId.of("Europe/Helsinki")).toInstant());
        reading1.setValue(20.6);
    
        SensorData reading2 = new SensorData();
        reading2.setSiteId("Ypsilon");
        reading2.setLocationId("2105");
        reading2.setSensorCategory("Exhaust air");
        reading2.setSensorAttribute("Humidity");
        reading2.setUnit("%");
        reading2.setTime(LocalDateTime.of(2020, Month.JANUARY, 28, 13, 26).atZone(ZoneId.of("Europe/Helsinki")).toInstant());
        reading2.setValue(38.7);
        
        readings.add(reading1);
        readings.add(reading2);
    }

    if (locationId == null || "2321".equals(locationId)) {
        SensorData reading1 = new SensorData();
        reading1.setSiteId("Ypsilon");
        reading1.setLocationId("2321");
        reading1.setSensorCategory("Exhaust air");
        reading1.setSensorAttribute("Temperature");
        reading1.setUnit("°C");
        reading1.setTime(LocalDateTime.of(2020, Month.JANUARY, 28, 13, 18).atZone(ZoneId.of("Europe/Helsinki")).toInstant());
        reading1.setValue(21.2);
    
        SensorData reading2 = new SensorData();
        reading2.setSiteId("Ypsilon");
        reading2.setLocationId("2321");
        reading2.setSensorCategory("Exhaust air");
        reading2.setSensorAttribute("Humidity");
        reading2.setUnit("%");
        reading2.setTime(LocalDateTime.of(2020, Month.JANUARY, 28, 13, 22).atZone(ZoneId.of("Europe/Helsinki")).toInstant());
        reading2.setValue(41.7);
        
        readings.add(reading1);
        readings.add(reading2);        
    }

    return readings;
  }
}