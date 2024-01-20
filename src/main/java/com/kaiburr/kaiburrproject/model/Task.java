package com.kaiburr.kaiburrproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {
    @Id
    private String id;
    private String name;
    private String assignee;
    private String project;
    private Date startTime;
    private String arunodhaiVProperty;
}
