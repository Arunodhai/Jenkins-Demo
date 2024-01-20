package com.kaiburr.kaiburrproject.controller;

import com.kaiburr.kaiburrproject.model.Task;
import com.kaiburr.kaiburrproject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
    
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable String id) {
        try {
            Task task = taskService.getTaskById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "404 Task not found"));
            return ResponseEntity.ok(task);
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }
    }



    @PutMapping
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/findByName")
    public ResponseEntity<Object> findTasksByName(@RequestParam String name) {
        try {
            List<Task> allTasks = taskService.getAllTasks();

            List<Task> matchingTasks = allTasks.stream()
                    .filter(task -> task.getName().contains(name))
                    .collect(Collectors.toList());

            if (matchingTasks.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 No tasks found with the specified name");
            } else {
                return ResponseEntity.ok(matchingTasks);
            }
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }
    }


    @GetMapping("/findFirst10TasksByAssignee")
    public ResponseEntity<Object> findFirst10TasksByAssignee(@RequestParam String assignee) {
        try {
            List<Task> first10Tasks = taskService.findFirst10TasksByAssignee(assignee);

            if (first10Tasks.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 No tasks found for the specified assignee");
            } else {
                return ResponseEntity.ok(first10Tasks);
            }
        } catch (ResponseStatusException ex) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
        }
    }

}
