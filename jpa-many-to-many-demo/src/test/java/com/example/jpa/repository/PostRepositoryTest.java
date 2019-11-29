package com.example.jpa.repository;

import com.example.jpa.model.Post;
import com.example.jpa.model.Tag;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class PostRepositoryTest {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private TagRepository tagRepository;

	@Test
	public void name() {
		postRepository.deleteAllInBatch();
		tagRepository.deleteAllInBatch();

		Post post = new Post("Hibernate Many to Many Example with Spring Boot",
				"Learn how to map a many to many relationship using hibernate",
				"Entire Post content with Sample code");

		Tag tag2 = new Tag("Hibernate");

		post.getTags().add(tag2);
		tag2.getPosts().add(post);

		postRepository.save(post);
	}
}