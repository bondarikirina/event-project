package by.bsu.samples.microservice.controller;

import by.bsu.samples.microservice.model.Event;
import by.bsu.samples.microservice.repository.EventRepository;
import by.bsu.samples.microservice.service.EventService;
import by.bsu.samples.microservice.service.EventServiceMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventTestController {
    @Autowired
    private EventServiceMongo eventServiceMongo;

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/EventTest")
    public List<Event> getLocation(
            @RequestParam(value="nameEvent", required=true) String nameEvent,
            @RequestParam(value="latitude", required=true) String latitude,
            @RequestParam(value="longitude", required=true) String longitude
    ) throws Exception {

        EventService locationService = new EventService();
        long id = this.eventServiceMongo.getMaxEmpId() + 1;
        Event ev=locationService.getLocation(id,nameEvent,latitude,longitude);
        this.eventRepository.insert(ev);
        List<Event> evs = this.eventRepository.findAll();
        return evs;
    }
}

