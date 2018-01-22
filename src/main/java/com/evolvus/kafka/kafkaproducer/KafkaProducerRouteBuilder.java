package com.evolvus.kafka.kafkaproducer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//Producer
		from("file:///home/user/Desktop/ITems/Training-23-Jan-2018/kafka-producer/source?antInclude=*.xml")
		.to("kafka:MyFirstTopic1?brokers=localhost:9092&groupId=testgroup");

		//Consumer
		from("kafka:MyFirstTopic1?brokers=localhost:9092&groupId=testgroup")
		.to("file:///home/user/Desktop/ITems/Training-23-Jan-2018/kafka-producer/destination");
	}

}
