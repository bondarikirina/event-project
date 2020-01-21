package by.bsu.samples.microservice.model;


import org.springframework.data.annotation.Id;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "evs")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Field(value = "NameEvent")
    private String nameEvent;

    @Field(value = "Latitude")
    private String latitude;

    @Field(value = "Longitude")
    private String longitude;


    public Event(Long id,String nameEvent, String latitude, String longitude) {
        this.id = id;
        this.nameEvent = nameEvent;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEvent() {
        return nameEvent;
    }
    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


}
