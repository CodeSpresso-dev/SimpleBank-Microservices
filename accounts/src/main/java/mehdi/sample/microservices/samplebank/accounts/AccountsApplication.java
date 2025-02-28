package mehdi.sample.microservices.samplebank.accounts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import jakarta.persistence.CollectionTable;
import mehdi.sample.microservices.samplebank.accounts.dto.AccountsContactInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts microservice REST API Documentation",
                description = "A SimpleBank Accounts microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Mahdi Shivaeifar",
                        email = "Shivaeifar.m@gmail.com",
                        url = "https://github.com/CodeSpresso-dev"
                ),
                license = @License(
                        name = "This is a sample project and is created tend to learning microservices.",
                        url = "https://github.com/CodeSpresso-dev/microservices/tree/main/accounts"
                )
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
