package com.library.service;

import java.util.List;

import com.library.model.Publisher;

public interface PublisherService {

	List<Publisher> getAllPublishers();
	void savePublisher(Publisher publisher);
	Publisher getPublisherById(long id);
	void deletePublisherById(long id);
}
