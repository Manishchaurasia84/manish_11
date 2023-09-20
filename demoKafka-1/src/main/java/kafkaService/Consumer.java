package kafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	//KafkaTemplate<name of the topic, parameter of the topic> 
	@Autowired
	  KafkaTemplate<String, String> kafkaTemplate;
	
	@KafkaListener(topics = "codeDecode_Topic", groupId = "codeDecode_group")
	public void listenToTopic(String recievedMessage) {
		System.out.println(" the message recieved is" +recievedMessage);
		
	}
}
