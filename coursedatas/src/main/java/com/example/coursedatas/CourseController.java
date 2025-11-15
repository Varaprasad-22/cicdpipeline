package com.example.coursedatas;

// import com.example.courses.dto.CourseDTO;
// import com.example.courses.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/courses")
public class CourseController {


private final CourseService service;


public CourseController(CourseService service) {
this.service = service;
}


@GetMapping
public List<CourseDTO> list() {
return service.getAllCourses();
}


@GetMapping("/{id}")
public CourseDTO getById(@PathVariable Long id) {
return service.getCourseById(id);
}


@PostMapping
public ResponseEntity<CourseDTO> create(@Valid @RequestBody CourseDTO dto) {
CourseDTO created = service.createCourse(dto);
return ResponseEntity.created(URI.create("/api/courses/" + created.getId())).body(created);
}


@PutMapping("/{id}")
public CourseDTO update(@PathVariable Long id, @Valid @RequestBody CourseDTO dto) {
return service.updateCourse(id, dto);
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
service.deleteCourse(id);
return ResponseEntity.noContent().build();
}
}