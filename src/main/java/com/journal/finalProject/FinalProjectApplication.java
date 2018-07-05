package com.journal.finalProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinalProjectApplication {

        private static final Logger log = LoggerFactory.getLogger(FinalProjectApplication.class);

        public static void main(String args[]) {
            SpringApplication.run(FinalProjectApplication.class, args);
        }

        @Bean
        public CommandLineRunner run(WeatherRepository repo) throws Exception {
            return (args) -> {
                Weather weatherService = new Weather();
                JournalFileWriter.newJournal(04,07,2018,"Provided by best Weather application!", weatherService, "Lodz,pl");
                JournalFileWriter.newJournal(04,07,2018,"Provided by best Weather application!", weatherService, "Warsaw,pl");

                MyDatabase newDatabase = new MyDatabase(log, repo);
                newDatabase.AddWeatherReports(weatherService);

                newDatabase.fetchAll();

                newDatabase.fetchByCity("Warsaw,pl");
            };
	}
}
