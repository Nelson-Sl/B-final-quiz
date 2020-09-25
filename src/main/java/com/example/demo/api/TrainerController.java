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
    public TrainerEntity addTrainer(@RequestBody @Valid Trainer trainer) {
        return this.trainerService.addTrainee(trainer);
    }

    @GetMapping
    // GTB: - 接口错误：应该查询所有未分组讲师，而非所有讲师
    public List<TrainerEntity> getTrainers() {
        return this.trainerService.findAllTrainers();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainer(@PathVariable Long id) {
        this.trainerService.deleteTrainer(id);
    }
}
