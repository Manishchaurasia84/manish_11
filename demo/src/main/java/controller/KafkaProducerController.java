package controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {



	    private KafkaProducer kafkaProducer;

	    public KafkaProducerController(KafkaProducer kafkaProducer) {
	        this.kafkaProducer = kafkaProducer;
	    }

	    @GetMapping("/publish")
	    public ResponseEntity<String> publish(@RequestParam("message") ProducerRecord message){
	        kafkaProducer.send(message);
	        return ResponseEntity.ok("Message sent to kafka topic");
	    }
	
}
