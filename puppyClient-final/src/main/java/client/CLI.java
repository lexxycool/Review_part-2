package client;

import model.Puppy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RestTemplate restTemplate = new RestTemplate();

        boolean stay = true;

        while (stay == true) {
            System.out.println("1.View all puppies\n2.View a puppy\n3.Add a puppy\n4.Quit");
            String option = scanner.nextLine();

            if (option.equals("1")) {
                Puppy[] puppyArr = restTemplate.getForObject("http://localhost:8080/all-puppies", Puppy[].class);
                for (Puppy puppy : puppyArr) {
                    System.out.println(puppy);
                }

            } else if (option.equals("2")) {
                System.out.println("Enter a puppy id:");
                String puppyId = scanner.nextLine();

                Puppy puppy = restTemplate.getForObject("http://localhost:8080/puppy/" + puppyId, Puppy.class);

                System.out.println(puppy);

            } else if (option.equals("3")) {
                System.out.println("Enter a String i.e. Fido,10,Female,false");
                String input = scanner.nextLine();

                String[] inputArr = input.split("\\,");
                Puppy puppy = new Puppy();

                puppy.setName(inputArr[0]);
                puppy.setWeight(Integer.parseInt(inputArr[1]));
                puppy.setGender(inputArr[2]);
                puppy.setPaperTrained(Boolean.parseBoolean(inputArr[3]));

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<Puppy> entity = new HttpEntity<>(puppy, headers);

                restTemplate.postForObject("http://localhost:8080/add-puppy", entity, Puppy.class);

            } else if (option.equals("4")) {
                stay = false;
            }

        }

    }
}
