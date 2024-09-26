package com.prudhviraj.production_ready_features.production_ready_features.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoDto {

    private Long userId; // Represents the ID of the user associated with the todo
    private Long id;     // Represents the ID of the todo item
    private String title; // The title or description of the todo item
    private boolean completed; // Status indicating whether the todo is completed or not

    // Default constructor
    public TodoDto() {
    }

    // Constructor with all fields
    public TodoDto(Long userId, Long id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }


}

