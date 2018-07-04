package com.journal.finalProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class FinalProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(FinalProjectApplication.class);

	public static void main(String args[]) {
		SpringApplication.run(FinalProjectApplication.class);
		JournalFileWriter.newJournal(04,07,2018,"Hello");
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"http://api.openweathermap.org/data/2.5/forecast?id=3093133&APPID=7a9cbbef0205f377c465a38e5aaf6696", Quote.class);
			log.info(quote.toString());
		};
	}

}
