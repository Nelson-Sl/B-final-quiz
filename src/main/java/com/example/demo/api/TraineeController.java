package com.example.demo.api;

import com.example.demo.Service.TraineeService;
import com.example.demo.domain.Trainee;
import com.example.demo.entity.TraineeEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/trainees")
public class TraineeController {
    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

//    @GetMapping("/students")
//    public List<Student> getStudentList() {
//        return studentListService.getStudentList();
//    }
//
//    @GetMapping("/randomTeams")
//    public Team[] getRandomTeam() {return studentListService.getRandomTeams(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeEntity addTrainee(@RequestBody @Valid Trainee trainee) {
         return this.traineeService.addTrainee(trainee);
    }

    @GetMapping
    public List<TraineeEntity> getTrainees() {
        return this.traineeService.findAllTrainees();
    }
}
