package com.nye.university.nyeuni.service;


import java.util.List;



import com.nye.university.nyeuni.dto.gondozo.GondozoRequestDto;
import com.nye.university.nyeuni.dto.gondozo.GondozoResponseDto;
import com.nye.university.nyeuni.entity.Gondozo;
import com.nye.university.nyeuni.exception.ResourceNotFoundException;


import com.nye.university.nyeuni.repository.GondozoRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import java.util.Optional;

@Service

public class GondozoService {

    @Autowired
    private GondozoRepository gondozoRepository;


    public GondozoService(GondozoRepository gondozoRepository) {
        this.gondozoRepository = gondozoRepository;
    }

    public GondozoResponseDto createGondozo (GondozoRequestDto gondozoRequestDto) {
        Gondozo gondozo = Gondozo.builder()
                .terulet(gondozoRequestDto.getTerulet())
                .gondozonev(gondozoRequestDto.getGondozonev())
                .build();
        Gondozo savedGondozo = gondozoRepository.save(gondozo);
        return mapToDto(savedGondozo);
    }

    public List<GondozoResponseDto> getAllGondozos () {
        return gondozoRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public GondozoResponseDto getGondozoById (Long id) throws ResourceNotFoundException {
        Optional<Gondozo> gondozoOptional = gondozoRepository.findById(id);
        Gondozo gondozo = gondozoOptional
                .orElseThrow(
                        () -> new ResourceNotFoundException("Nincs gondozo ezzel az id-val: " )
                );
        return mapToDto(gondozo);
    }

    public GondozoResponseDto updateGondozo(Long id, GondozoResponseDto requestDto) throws ResourceNotFoundException {
        Gondozo gondozo = gondozoRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Nincs gondozo ezzel az id-val: " + id)
                );

        gondozo.setTerulet(requestDto.getTerulet());
        gondozo.setGondozonev(requestDto.getGondozonev());
        Gondozo updatedGondozo = gondozoRepository.save(gondozo);
        return mapToDto(updatedGondozo);

    }

    public void deleteGondozo (Long id) {
        gondozoRepository.deleteById(id);
    }

    private GondozoResponseDto mapToDto(Gondozo gondozo) {
        return GondozoResponseDto.builder()
                .id(gondozo.getId())
                .terulet(gondozo.getTerulet())
                .gondozonev(gondozo.getGondozonev())
                .build();
    }


}



//package com.nye.university.nyeuni.Service;
//
//import java.util.List;
//import com.nye.university.nyeuni.dto.course.CourseRequestDto;
//import com.nye.university.nyeuni.dto.course.CourseResponseDto;
//import com.nye.university.nyeuni.entity.Course;
//import com.nye.university.nyeuni.exception.ResourceNotFoundException;
//import com.nye.university.nyeuni.repository.CourseRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class CourseService {
//
//    @Autowired
//    private CourseRepository courseRepository;
//
//
//
//    public CourseResponseDto createCourse (CourseRequestDto courseRequestDto) {
//        Course course = Course.builder()
//                .name(courseRequestDto.getName())
//                .teacherName(courseRequestDto.getTeacherName())
//                .build();
//        Course savedCourse =courseRepository.save(course);
//        return mapToDto(savedCourse);
//    }
//
//    public List<CourseResponseDto> getAllCourses () {
//        return courseRepository.findAll()
//            .stream()
//            .map(this::mapToDto)
//            .toList();
//
//    }
//
//    public CourseResponseDto getCourseById (Long id) {
//            Optional<Course> courseOptional = courseRepository.findById(id);
//            Course course = courseOptional
//                    .orElseThrow(
//                            () -> new ResourceNotFoundException("Course not found by id: " )
//                    );
//        return mapToDto(course);
//    }
//
//    public CourseResponseDto updateCourse(Long id, CourseRequestDto requestDto) {
//        Course course = courseRepository.findById(id)
//                .orElseThrow(
//                ()-> new ResourceNotFoundException("Courses not found by id: " + id)
//                );
//
//        course.setName(requestDto.getName());
//        course.setTeacherName(requestDto.getTeacherName());
//
//        Course updatedCourse = courseRepository.save(course);
//        return mapToDto(updatedCourse);
//
//    }
//
//    public void deleteCourse (Long id) {
//        courseRepository.deleteById(id);
//    }
//    private CourseResponseDto mapToDto(Course course) {
//        return CourseResponseDto.builder()
//                .id(course.getId())
//                .name(course.getName())
//                .teacherName(course.getTeacherName())
//                .build();
//    }
//}