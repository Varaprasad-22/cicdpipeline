package com.example.coursedatas;

// import com.example.courses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<com.example.coursedatas.Course, Long> {
// add custom queries if needed
}