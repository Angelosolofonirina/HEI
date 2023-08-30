package hei.concours.hei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "hei.concours.hei")
public class ConcoursApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcoursApplication.class, args);
	}

}
