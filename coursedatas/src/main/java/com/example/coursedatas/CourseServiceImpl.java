package com.example.coursedatas;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

// import com.example.courses.dto.CourseDTO;
@Service
public class CourseServiceImpl implements CourseService {


private final CourseRepository repository;


public CourseServiceImpl(CourseRepository repository) {
this.repository = repository;
}


private CourseDTO toDTO(Course c) {
CourseDTO dto = new CourseDTO();
dto.setId(c.getId());
dto.setTitle(c.getTitle());
dto.setDescription(c.getDescription());
dto.setDurationHours(c.getDurationHours());
return dto;
}


private Course toEntity(CourseDTO dto) {
Course c = new Course();
c.setTitle(dto.getTitle());
c.setDescription(dto.getDescription());
c.setDurationHours(dto.getDurationHours());
return c;
}


@Override
public CourseDTO createCourse(CourseDTO course) {
Course saved = repository.save(toEntity(course));
return toDTO(saved);
}


@Override
public CourseDTO getCourseById(Long id) {
Course c = repository.findById(id).orElseThrow();
return toDTO(c);
}


@Override
public List<CourseDTO> getAllCourses() {
return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
}


@Override
public CourseDTO updateCourse(Long id, CourseDTO course) {
Course existing = repository.findById(id).orElseThrow();
existing.setTitle(course.getTitle());
existing.setDescription(course.getDescription());
existing.setDurationHours(course.getDurationHours());
Course updated = repository.save(existing);
return toDTO(updated);
}


@Override
public void deleteCourse(Long id) {
Course existing = repository.findById(id).orElseThrow();
repository.delete(existing);
}
}
