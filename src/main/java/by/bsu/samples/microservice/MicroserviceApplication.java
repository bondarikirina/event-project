package by.bsu.samples.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@SpringBootApplication
public class MicroserviceApplication {
  public static void main(String[] args) {
    SpringApplication.run(MicroserviceApplication.class, args);
  }

  @Bean
  public MongoTemplate mongoTemplat(MongoDbFactory mongoDbFactory, MongoMappingContext context) {

    MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
    converter.setTypeMapper(new DefaultMongoTypeMapper(null));

    MongoTemplate mongoTemplat = new MongoTemplate(mongoDbFactory, converter);

    return mongoTemplat;

  }


}
/*
@SpringBootApplication
public class MicroserviceApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroserviceApplication.class, args);
  }

}
*/