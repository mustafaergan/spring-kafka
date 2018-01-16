package com.mustafaergan.kafka.service;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiver {

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = "${kafka.topic.boot}")
	public void receive(ConsumerRecord<String, String> consumerRecord) {
		
		consumerRecord.value();
		latch.countDown();
		
	}

}
