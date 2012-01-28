package org.codefish.blog.controller;

import javax.annotation.Resource;

import org.codefish.blog.JsonResponse;
import org.codefish.blog.model.Blog;
import org.codefish.blog.mongo.repository.BlogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.data.document.mongodb.MongoTemplate;
import org.springframework.data.document.mongodb.query.Criteria;
import org.springframework.data.document.mongodb.query.Query;
import org.springframework.data.document.mongodb.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.DBCollection;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="mongoTemplate")
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private BlogRepository blogRepository;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		
		MongoOperations mongoOperation = (MongoOperations)mongoTemplate;
		 /*
        Blog blog = new Blog("mongoblog", "this is a new mongodb blog");
 
        //save
        mongoOperation.save(blog);
 
        //find
        logger.info(mongoOperation.findById(blog.getId(), Blog.class).toString());
        
        logger.info(blogRepository.findByTitle("mongoblog").size()+":size");
 
        //update
        mongoOperation.updateFirst(new Query(Criteria.where("title").is("monoblog")),Update.update("body", "new body text"),Blog.class);
 
        //find
        Blog updatedUser = mongoOperation.findOne(new Query(Criteria.where("title").is("monoblog")),Blog.class);
 
        System.out.println("updatedUser : " + updatedUser);
 
        //delete
        mongoOperation.remove(updatedUser);
 
        //List
        logger.info("blog collection"+mongoOperation.getCollectionName(Blog.class));
        DBCollection listUser = mongoOperation.getCollection(mongoOperation.getCollectionName(Blog.class));
        System.out.println("Number of user = " + listUser.count());
		*/
		return "home";
	}
	
	/**
	 * json test
	 * @return
	 */
	@RequestMapping(value="/test.json", method=RequestMethod.GET)
	public @ResponseBody JsonResponse test(){
		JsonResponse response = new JsonResponse();
		response.setMessage("hello world");
		return response;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}

