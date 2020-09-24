package com.example.demo.common;

import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;

public class Converters {
    public static TraineeEntity traineeEntityConverter(Trainee trainee) {
        return TraineeEntity.builder()
                .name(trainee.getName())
                .email(trainee.getEmail())
                .github(trainee.getGithub())
                .office(trainee.getOffice())
                .zoomId(trainee.getZoomId())
                .build();
    }
}
