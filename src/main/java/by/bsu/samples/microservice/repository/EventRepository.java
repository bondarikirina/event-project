package by.bsu.samples.microservice.repository;

import by.bsu.samples.microservice.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, Long> {
}
