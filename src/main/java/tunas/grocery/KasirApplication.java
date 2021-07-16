package tunas.grocery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KasirApplication {

	private static final Logger log = LoggerFactory.getLogger(KasirApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KasirApplication.class, args);
	}

}
