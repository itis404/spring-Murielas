package ru.itis.musicform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MusicformApplication {
	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(MusicformApplication.class, args);
	}

}
