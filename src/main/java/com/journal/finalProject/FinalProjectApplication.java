package com.journal.finalProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProjectApplication implements CommandLineRunner {

        private static final Logger log = LoggerFactory.getLogger(FinalProjectApplication.class);

        public static void main(String args[]) {
            SpringApplication.run(FinalProjectApplication.class, args);
        }

        @Override
        public void run(String... strings) throws Exception {
            Weather weatherService = new Weather();
            JournalFileWriter.newJournal(04,07,2018,"Provided by best Weather application!", weatherService);

			MyDatabase newDatabase = new MyDatabase(log);
			newDatabase.CreateDatabase();
			newDatabase.InsertWeatherReport(weatherService);
	}

}
