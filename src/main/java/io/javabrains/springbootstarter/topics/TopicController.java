package io.javabrains.springbootstarter.topics;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
@RequestMapping("/topics")
public List<Topics> getTopic()
{
  return topicService.getAllTopics();
}
@RequestMapping("/topics/{id}")
public Topics getTopic(@PathVariable String id)
{
  return topicService.getTopics(id);
}

@RequestMapping(method=RequestMethod.POST, value="/topics")
public void addTopic(@RequestBody Topics topics)
{
	 topicService.AddTopic(topics);
}
}
