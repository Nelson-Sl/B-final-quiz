package com.example.demo.Service;

import com.example.demo.common.Converters;
import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

@Service
public class TraineeService {
    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

//    public List<Student> getStudentList() {
//        return StudentData.getStudentList();
//    }
//
//    public Team[] getRandomTeams() {
//        return TeamData.getRandomTeams();
//    }

    public TraineeEntity addTrainee(Trainee trainee) {
        TraineeEntity traineeSaving = Converters.traineeEntityConverter(trainee);
        return this.traineeRepository.save(traineeSaving);
    }
}
