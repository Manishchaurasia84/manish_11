package consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import dto.User;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

	private static final Log  Logger  =LogFactory.getLog(RabbitMQJsonConsumer.class);
	 final static org.slf4j.Logger logger = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
	@RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
	public void consumeJsonMessage(User user ) {
		
	}
}
