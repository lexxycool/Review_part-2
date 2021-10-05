package com.techelevator.clientreview;

import com.techelevator.clientreview.model.UserDTO;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@SpringBootApplication
public class ClientReviewApplication {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(ClientReviewApplication.class, args);
	}

}
