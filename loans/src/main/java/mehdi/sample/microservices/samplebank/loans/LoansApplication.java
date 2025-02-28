package mehdi.sample.microservices.samplebank.loans;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "A Simple Bank Loans microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Mahdi Shivaeifar",
						email = "Shivaeifar.m@gmail.com",
						url = "https://github.com/CodeSpresso-dev"
				),
				license = @License(
						name = "This is a sample project and is created tend to learning microservices.",
						url = "https://github.com/CodeSpresso-dev/microservices/tree/main/loans"
				)
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}
}
