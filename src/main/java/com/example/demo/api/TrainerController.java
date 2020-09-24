package com.example.demo.api;

import com.example.demo.Service.TrainerService;
import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.entity.TraineeEntity;
import com.example.demo.entity.TrainerEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerEntity addTrainee(@RequestBody @Valid Trainer trainer) {
        return this.trainerService.addTrainee(trainer);
    }

    @GetMapping
    public List<TrainerEntity> getTrainees() {
        return this.trainerService.findAllTrainers();
    }
}
