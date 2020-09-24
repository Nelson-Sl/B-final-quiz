package com.example.demo.domain;

import com.example.demo.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {
    @NotEmpty(message = Constants.TRAINER_NAME_NULL_EXCEPTION_MESSAGE)
    private String name;
}
