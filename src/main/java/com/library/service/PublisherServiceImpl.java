package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Publisher;
import com.library.repository.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService{
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	@Override
	public List<Publisher> getAllPublishers() {
		return publisherRepository.findAll();
	}

	@Override
	public void savePublisher(Publisher publisher) {
		publisherRepository.save(publisher);
		
	}

	@Override
	public Publisher getPublisherById(long id) {
		return publisherRepository.findById(id).get();
	}

	@Override
	public void deletePublisherById(long id) {
		publisherRepository.deleteById(id);
		
	}

}
