package com.mustafaergan.kafka.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mustafaergan.kafka.service.KafkaReceiver;
import com.mustafaergan.kafka.service.KafkaSender;

@RestController
@RequestMapping("kafka")
public class KafkaTestController {
	
	  @Autowired
	  private KafkaSender sender;

	  @Autowired
	  private KafkaReceiver receiver;
	
	
	Gson gson = new Gson();
	
    @RequestMapping("/")
    public String get(@RequestParam(value="key") String key) throws InterruptedException {
    	receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        return gson.toJson(receiver.getLatch().getCount());
    }
    
    @RequestMapping("/send/")
    public void set(@RequestParam(value="key") String key,
    					@RequestParam(value="value") String value) {
    	sender.send(key, value);
    }
	
}
