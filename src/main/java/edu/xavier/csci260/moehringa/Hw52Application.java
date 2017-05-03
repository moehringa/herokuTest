package edu.xavier.csci260.moehringa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@ComponentScan("edu.xavier.csci260.moehringa")
public class Hw52Application {

	public static void main(String[] args) {
		SpringApplication.run(Hw52Application.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
}
