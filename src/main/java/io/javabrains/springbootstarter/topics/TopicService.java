package io.javabrains.springbootstarter.topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Retry.Topic;
@Service
public class TopicService 
{
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topics> topics= new ArrayList<>(Arrays.asList(
			new Topics("spring","spring framework","Spring framework description"),
			new Topics("java","java framework","java description"),
			new Topics("javascript","javascript framework","javascript description")
			));
	
	public List<Topics> getAllTopics()
	{
		//return topics;
		List<Topics> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}

	public Topics getTopics(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
	}
	
	public void AddTopic(Topics topic)
	{
		//topics.add(topic);
		topicRepository.save(topic);
	}
	
	

}
