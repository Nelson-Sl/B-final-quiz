package com.example.demo.Service;

import com.example.demo.Exception.TrainerNotSatisfiedForGroupingException;
import com.example.demo.common.Constants;
import com.example.demo.domain.Group;
import com.example.demo.domain.Trainee;
import com.example.demo.entity.GroupEntity;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.entity.TrainerEntity;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final TraineeRepository traineeRepository;
    private final TrainerRepository trainerRepository;
    // GTB: - 无用的代码应该删除
    private final TraineeService traineeService;
    private final TrainerService trainerService;

    public GroupService(GroupRepository groupRepository, TraineeRepository traineeRepository, TrainerRepository trainerRepository, TraineeService traineeService, TrainerService trainerService) {
        this.groupRepository = groupRepository;
        this.traineeRepository = traineeRepository;
        this.trainerRepository = trainerRepository;
        this.traineeService = traineeService;
        this.trainerService = trainerService;
    }


    public List<Group> autoGenerateGroup() {
        // GTB: - magic number
        if(trainerRepository.count() < 2) {
            throw new TrainerNotSatisfiedForGroupingException(Constants.TRAINER_NOT_ENOUGH_EXCEPTION_MESSAGE);
        }
        generateEmptyGroupWithName();
        return new ArrayList<>();
    }

    private void generateEmptyGroupWithName() {
        Long team_count = trainerRepository.count() / Constants.GROUP_TRAINER_NUM;
        for (int teamNum = 1; teamNum <=team_count; teamNum++) {
            String teamName = teamNum + Constants.GROUP_NAME_SUFFIX;
            List<TraineeEntity> trainees = new ArrayList<>();
            List<TrainerEntity> trainers = new ArrayList<>();
            GroupEntity newGroup = GroupEntity.builder().teamName(teamName).trainees(trainees).trainers(trainers).build();
            this.groupRepository.save(newGroup);
        }
    }
}
