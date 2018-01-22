package com.evolvus.kafka.kafkaproducer;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.evolvus")
public class KafkaProducerApplication {

	@Autowired
	private KafkaProducerRouteBuilder routeBuilder;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Bean
	public CamelContext createKafkaProducer() throws Exception {
		CamelContext ctx = new SpringCamelContext();
		ctx.addRoutes(routeBuilder);
		ctx.setAutoStartup(true);
		return ctx;
	}

}
