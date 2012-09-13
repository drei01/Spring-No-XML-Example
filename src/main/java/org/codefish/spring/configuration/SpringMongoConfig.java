package org.codefish.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.document.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;

/**
 * Configuration class for mongodb template
 * @author Matthew
 */
@Configuration
@ImportResource(value="WEB-INF/spring/mongo-config.xml")//import the <mongo:repository> code because we can't do this in java atm
public class SpringMongoConfig extends AbstractMongoConfiguration{
	private String databaseName = "codefish";	
	
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new Mongo("localhost");
	}
 
	@Override
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongo(), databaseName);
		return mongoTemplate;
	}
	
	@Override
	public String getDatabaseName() {
		return databaseName;
	}
	
	@Override
	public String getMappingBasePackage() {
		return "org.codefish.blog.mongo.repository";
	}
}
