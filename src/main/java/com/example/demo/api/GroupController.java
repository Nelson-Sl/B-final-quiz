package com.example.demo.api;

import com.example.demo.Service.GroupService;
import com.example.demo.domain.Group;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/auto-grouping")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Group> autoGenerateGroup() {
        return this.groupService.autoGenerateGroup();
    }
}
