package com.example.demo.Service;

import com.example.demo.Exception.TraineeNotFoundException;
import com.example.demo.common.Constants;
import com.example.demo.common.Converters;
import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class TraineeService {
    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    // GTB: - 注释的代码应该删除
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

    public List<TraineeEntity> findAllTrainees() {
        // GTB: - 推荐使用JpaRepository接口的findAll方法，直接返回List
        Iterable<TraineeEntity> traineeEntities = this.traineeRepository.findAll();
        List<TraineeEntity> traineeEntityList = new ArrayList<>();

        Iterator<TraineeEntity> traineeEntitiesIterator = traineeEntities.iterator();
        while(traineeEntitiesIterator.hasNext()) {
            traineeEntityList.add(traineeEntitiesIterator.next());
        }

        return traineeEntityList;
    }

    public void deleteTrainee(Long id) {
        if(this.traineeRepository.existsById(id)) {
            this.traineeRepository.deleteById(id);
        }else {
            throw new TraineeNotFoundException(Constants.TRAINEE_NOT_FOUND_EXCEPTION_MESSAGE);
        }
    }
}
