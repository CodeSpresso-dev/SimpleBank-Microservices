package mehdi.sample.microservices.samplebank.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class AccountsDto {
    @NotNull(message = "Account number can not be null or empty")
    @Range(min = 1000000000L,max = 9999999999L,message = "Account number should have exactly 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "Account type can not be null or empty")
    private String accountType;

    @NotEmpty(message = "Branch address can not be null or empty")
    private String branchAddress;
}
