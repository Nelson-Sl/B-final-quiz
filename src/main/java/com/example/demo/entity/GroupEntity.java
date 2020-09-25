package com.example.demo.entity;

import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "group")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "TraineeEntity")
    // GTB: - 集合类型字段一般在字段声明时就初始化为空集合
    private List<TraineeEntity> trainees;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "TrainerEntity")
    private List<TrainerEntity> trainers;
}
