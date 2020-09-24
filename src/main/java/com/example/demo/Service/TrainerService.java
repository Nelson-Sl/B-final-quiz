package com.example.demo.Service;

import com.example.demo.common.Converters;
import com.example.demo.domain.Trainer;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public TrainerEntity addTrainee(Trainer trainer) {
        TrainerEntity trainerSaving = Converters.trainerEntityConverter(trainer);
        return this.trainerRepository.save(trainerSaving);
    }
}
