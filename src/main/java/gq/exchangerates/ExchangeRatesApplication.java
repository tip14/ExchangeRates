package gq.exchangerates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ExchangeRatesApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) throws Exception {
		return application.sources(ExchangeRatesApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ExchangeRatesApplication.class, args);
	}
}
