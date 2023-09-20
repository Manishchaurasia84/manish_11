package config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver;

@Configuration
public class RabbitMQConfig {

   @Value("${rabbitmq.queue.name}")
	  private String queue;
   
   @Value("${rabbitmq.queue.json.name}")
	  private String jsonQueue;
   
   
   @Value("${rabbitmq.exchange.name}")
   private String exchange;
   
   
	//spring bean for rabbitmq queue
   
   @Value("${rabbitmq.routing.key}")
   private String routingkey;
   //spring bean for rabbitmq
   
   @Value("${rabbitmq.routing.json.key}")
   private String routingJsonkey;
   
   //spring bean for queue (store json message)
   @Bean 
	public Queue queue() {
		return new Queue("queue");
	}
   @Bean
    public Queue jsonQueue() {
		return new Queue(jsonQueue);
    	
    }
   @Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
   
   
   //binding between queue and exchange using routing key
   @Bean
   public Binding bind() {
	   return BindingBuilder.bind(queue()).to(exchange()).with(routingkey);
   }
   
   //binding between jsonQueue and exchange using routing key
   @Bean
   public Binding jsonbinding() {
	   return BindingBuilder.bind(jsonQueue()).to(exchange()).with(routingkey);
	   
   }
   @Bean
   public MessageConverter converter() {
	   return new Jackson2JsonMessageConverter();
   }
   
   @Bean
   public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
	   RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	   rabbitTemplate.setMessageConverter(converter());
	   return rabbitTemplate;
   }
}

