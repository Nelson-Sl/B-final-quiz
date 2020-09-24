package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data //getSet属性
@Builder //构建对象
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private String teamName;
    private List<Trainee> teamMembers;
}
