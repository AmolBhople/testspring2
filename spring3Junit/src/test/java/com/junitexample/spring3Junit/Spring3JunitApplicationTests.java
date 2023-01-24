package com.junitexample.spring3Junit;

import com.sun.xml.txw2.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class Spring3JunitApplicationTests {

	@Test
	void contextLoads() {
	}

	private void assertInsertSucceeds(ConfigurableApplicationContext context) {
		String name = "A";

//		MongoTemplate mongo = context.getBean(MongoTemplate.class);
//		Document doc = Document.parse("{\"name\":\"" + name + "\"}");
//		Document inserted = mongo.insert(doc, "items");
//
//		assertNotNull(inserted.get("_id"));
//		assertEquals(inserted.get("name"), name);
	}
}
