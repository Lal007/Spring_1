package Lesson_7.services;


import Lesson_7.entities.Course;
import Lesson_7.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {
    private CoursesRepository coursesRepository;

    @Autowired
    public void setCoursesRepository(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public List<Course> getAllCoursesList() {
        return (List<Course>) coursesRepository.findAll();
    }

    public Course getCourseById(Long id) {
        Optional<Course> course = coursesRepository.findById(id);
        return course.orElse(null);
    }

    public Course addOrUpdateCourse(Course course) {
        return coursesRepository.save(course);
    }

    public void removeCourse(Long courseId) {
        coursesRepository.deleteById(courseId);
    }
}
