package com.example.coursedatas;
// 
// import com.example.courses.dto.CourseDTO;


import java.util.List;

import org.springframework.stereotype.Service;

public interface CourseService {
CourseDTO createCourse(CourseDTO course);
CourseDTO getCourseById(Long id);
List<CourseDTO> getAllCourses();
CourseDTO updateCourse(Long id, CourseDTO course);
void deleteCourse(Long id);
}