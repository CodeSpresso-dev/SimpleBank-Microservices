package mehdi.sample.microservices.samplebank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
@Data
public class CustomerDto {

    @Schema(
            description = "Name of the customer",
            example = "Simple Bank"
    )
    @NotEmpty(message = "Name can not be null or empty")
    @Size(min = 5, max = 25, message = "The length of customer name should be between 5 and 25")
    private String name;

    @Schema(
            description = "Name address of the customer",
            example = "Simple_Bank@Test.com"
    )
    @NotEmpty(message = "Email address can not be null or empty")
    @Email(message = "Email address is not valid value")
    private String email;

    @Schema(
            description = "Mobile number of the customer",
            example = "09142222222"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should have 10 digits")
    private String mobileNumber;

    @Schema(
            name = "Accounts",
            description = "Account details of the customer"
    )
    @Valid
    private AccountsDto accountsDto;
}
