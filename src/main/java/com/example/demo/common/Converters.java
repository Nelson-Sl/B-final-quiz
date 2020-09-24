package com.example.demo.common;

import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.entity.TrainerEntity;

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

    public static TrainerEntity trainerEntityConverter(Trainer trainer) {
        return TrainerEntity.builder()
                .name(trainer.getName())
                .build();
    }
}
