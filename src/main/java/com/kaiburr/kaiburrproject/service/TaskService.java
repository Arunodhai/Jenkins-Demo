package com.kaiburr.kaiburrproject.service;

import com.kaiburr.kaiburrproject.model.Task;
import com.kaiburr.kaiburrproject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Comparator;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task) {
        String candidateName = "ArunodhaiV";
        String randomCharacters = generateRandomCharacters(candidateName);
        task.setArunodhaiVProperty(randomCharacters);
        return taskRepository.save(task);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public List<Task> findFirst10TasksByAssignee(String assignee) {
        List<Task> allTasksByAssignee = taskRepository.findByAssignee(assignee);
        List<Task> first10Tasks = allTasksByAssignee.stream()
                .sorted(Comparator.comparing(Task::getStartTime))
                .limit(10)
                .collect(Collectors.toList());

        return first10Tasks;

    }

    private String generateRandomCharacters(String candidateName) {
        int length = 5;
        String randomCharacters = RandomStringUtils.random(length, candidateName);
        return randomCharacters;
    }
}
