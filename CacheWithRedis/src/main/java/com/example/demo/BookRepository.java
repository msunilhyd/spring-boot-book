package com.example.demo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String>{

	@CachePut(value = "book", key = "#title")
	Book findByTitle(String title);
	
	@CacheEvict (value = "book", key = "#title")
	void delete(String title);
}
