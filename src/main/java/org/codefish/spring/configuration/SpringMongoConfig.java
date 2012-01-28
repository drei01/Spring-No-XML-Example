package org.codefish.spring.configuration;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.authentication.UserCredentials;
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
	private static StandardPBEStringEncryptor passwordEncryptor;
	private String databaseName = "mattreid";
	static{//set the password in a static block so it is visible to the application for a shorter time 
		passwordEncryptor = new StandardPBEStringEncryptor();
		passwordEncryptor.setPassword("");
	}	
	
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new Mongo("flame.mongohq.com",27099);
	}
 
	@Override
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		UserCredentials userCredentials = new UserCredentials("drei01", passwordEncryptor.decrypt("IvYaqrMEzg2zju0ra4mobQ=="));
		MongoTemplate mongoTemplate = new MongoTemplate(mongo(), databaseName, userCredentials);
		return mongoTemplate;
	}
	
	@Override
	public String getDatabaseName() {
		return databaseName;
	}
}
