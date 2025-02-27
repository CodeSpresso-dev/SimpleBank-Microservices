package mehdi.sample.microservices.samplebank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
@Data
public class AccountsDto {
    @Schema(
            description = "Account number in the Simple Bank"
    )
    @NotNull(message = "Account number can not be null or empty")
    @Range(min = 1000000000L, max = 9999999999L, message = "Account number should have exactly 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type in the Simple Bank",
            example = "Savings"
    )
    @NotEmpty(message = "Account type can not be null or empty")
    private String accountType;

    @Schema(
            description = "Simple Bank branch address"
    )
    @NotEmpty(message = "Branch address can not be null or empty")
    private String branchAddress;
}
