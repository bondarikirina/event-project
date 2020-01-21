package by.bsu.samples.microservice.service;


import by.bsu.samples.microservice.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class EventServiceMongoImpl implements EventServiceMongo {

    @Autowired
    MongoTemplate mongoTemplat;

    public long getMaxEmpId() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "id"));
        query.limit(1);
        Event maxObject = mongoTemplat.findOne(query, Event.class);
        if (maxObject == null) {
            return 0L;
        }
        return maxObject.getId();
    }
}