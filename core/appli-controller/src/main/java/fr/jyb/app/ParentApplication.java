package fr.jyb.app;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class ParentApplication implements CommandLineRunner {

	public static void main(String [] args) {
		SpringApplication.run(ParentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("running toototo");
		//System.out.println("")
	}
}
