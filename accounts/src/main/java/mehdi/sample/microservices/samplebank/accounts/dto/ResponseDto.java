package mehdi.sample.microservices.samplebank.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ResponseDto {
    private String statusCode;
    private String statusMessage;
}
