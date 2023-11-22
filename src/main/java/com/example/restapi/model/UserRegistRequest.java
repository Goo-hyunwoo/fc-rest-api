package com.example.restapi.model;

import com.example.restapi.annotation.PhoneNumber;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegistRequest {

//    @NotBlank
    private String name;

    private String nickName;

    @NotBlank
    @Size(min = 3, max = 12)
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @PhoneNumber
//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다.")
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt; //ISO-8620 "YYYY-MM-DDTHH:mm:ss"

    @AssertTrue(message = "name or nickName 은 반드시 1개 이상 존재해야 합니다.")
//    @AssertFalse
    public boolean isNameCheck() {
        if(Objects.nonNull(name) && !name.isBlank() ) {
            return true;
        }
        if(Objects.nonNull(nickName) && !nickName.isBlank()) {
            return true;
        }
        return false;
    }

}
