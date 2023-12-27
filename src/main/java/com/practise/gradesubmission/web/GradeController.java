package com.practise.gradesubmission.web;

import java.util.Collection;

import com.practise.gradesubmission.entity.Grade;
import com.practise.gradesubmission.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeService gradeService;
    
    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> getGrade(@PathVariable Long studentId, @PathVariable Long courseId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Collection<Grade>> getGradesForStudent(@PathVariable Long studentId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<Collection<Grade>> getGradesForCourse(@PathVariable Long courseId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<Grade>> getGrades(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> saveGrade(@PathVariable Long studentId, @PathVariable Long courseId, @RequestBody Grade grade){
        return new ResponseEntity<>(gradeService.saveGrade(grade, studentId, courseId), HttpStatus.CREATED);
    }

    @PutMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long studentId, @PathVariable Long courseId, @RequestBody Grade grade){
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @DeleteMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteGrade(@PathVariable Long studentId, @PathVariable Long courseId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
