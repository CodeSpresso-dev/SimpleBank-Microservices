package mehdi.sample.microservices.samplebank.accounts.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty(message = "Name can not be null or empty")
    @Size(min = 5, max = 25, message = "The length of customer name should be between 5 and 25")
    private String name;

    @NotEmpty(message = "Email address can not be null or empty")
    @Email(message = "Email address is not valid value")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should have 10 digits")
    private String mobileNumber;

    @Valid
    private AccountsDto accountsDto;
}
