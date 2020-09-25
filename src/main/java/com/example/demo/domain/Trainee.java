package com.example.demo.domain;

import com.example.demo.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trainee {
    @NotEmpty(message = Constants.TRAINEE_NAME_NULL_EXCEPTION_MESSAGE)
    // GTB: - String类型的校验推荐使用@NotBlank
    private String name;
    @NotEmpty(message = Constants.TRAINEE_OFFICE_NULL_EXCEPTION_MESSAGE)
    private String office;
    @NotEmpty(message = Constants.TRAINEE_EMAIL_NULL_EXCEPTION_MESSAGE)
    @Email(message = Constants.EMAIL_FORMAT_INVALID_EXCEPTION_MESSAGE)
    private String email;
    @NotEmpty(message = Constants.TRAINEE_GITHUB_NULL_EXCEPTION_MESSAGE)
    private String github;
    @NotEmpty(message = Constants.TRAINEE_ZOOMID_NULL_EXCEPTION_MESSAGE)
    private String zoomId;

}
