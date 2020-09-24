package com.example.demo.Service;

import com.example.demo.common.Converters;
import com.example.demo.domain.Trainer;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public List<TrainerEntity> findAllTrainers() {
        Iterable<TrainerEntity> trainerEntities = this.trainerRepository.findAll();
        List<TrainerEntity> trainerEntityList = new ArrayList<>();

        Iterator<TrainerEntity> trainerEntitiesIterator = trainerEntities.iterator();
        while(trainerEntitiesIterator.hasNext()) {
            trainerEntityList.add(trainerEntitiesIterator.next());
        }

        return trainerEntityList;
    }
}
