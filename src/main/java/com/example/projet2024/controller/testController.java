package com.example.projet2024.controller;

import com.example.projet2024.entite.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projet2024.interfaceService.testInterfce;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
@CrossOrigin("*")
public class testController {

     @Autowired
    private testInterfce testInterface;

    @GetMapping
    public ResponseEntity<List<Test>> getAllTests() {
        List<Test> tests = testInterface.getAllTests();
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }




    @CrossOrigin("*")
    @GetMapping("/getPost/{postId}")
    public ResponseEntity<List<Test>> getTestsByPostId(@PathVariable Long postId) {
        List<Test> tests = testInterface.getTestsByPostId(postId);
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    @GetMapping("/{testId}")
    public ResponseEntity<Test> getTestById(@PathVariable Long testId) {
        Test test = testInterface.getTestById(testId);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Test> createTest(@PathVariable Long postId, @RequestBody Test test) {
        Test createdTest = testInterface.createTest(postId, test);
        return new ResponseEntity<>(createdTest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Test> updateTest(@PathVariable Long id, @RequestBody Test updatedTest) {
        Test result = testInterface.updateTest(id, updatedTest);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        testInterface.deleteTest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
