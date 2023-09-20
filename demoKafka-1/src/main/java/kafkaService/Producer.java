package kafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	
	//KafkaTemplate<name of the topic, parameter of the topic> 
		@Autowired
		  KafkaTemplate<String, String> kafkaTemplate;
		
		public void sendMsgToTopic(String message) {
			kafkaTemplate.send("codeDecode_Topic", message);
		}

}
