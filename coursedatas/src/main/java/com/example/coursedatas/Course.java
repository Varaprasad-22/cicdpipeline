package com.example.coursedatas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "courses")
public class Course {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@NotBlank
@Size(max = 200)
private String title;


@Size(max = 1000)
private String description;


@NotNull
private Integer durationHours; // e.g., duration in hours


public Course() {
}


public Course(String title, String description, Integer durationHours) {
this.title = title;
this.description = description;
this.durationHours = durationHours;
}


// getters and setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public String getTitle() { return title; }
public void setTitle(String title) { this.title = title; }


public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }


public Integer getDurationHours() { return durationHours; }
public void setDurationHours(Integer durationHours) { this.durationHours = durationHours; }
}