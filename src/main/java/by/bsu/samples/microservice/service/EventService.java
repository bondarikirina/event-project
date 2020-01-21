package by.bsu.samples.microservice.service;

import by.bsu.samples.microservice.model.Event;
import org.springframework.beans.factory.annotation.Autowired;

public class EventService {

    @Autowired
    public Event getLocation(Long id,String nameE, String lat, String lon)  {
        return new Event(id,nameE, lat, lon);
    }
}
