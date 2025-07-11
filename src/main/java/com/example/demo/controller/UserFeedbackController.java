package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserFeedbackDto;
import com.example.demo.service.UserFeedbackService;

import lombok.AllArgsConstructor;

@Controller
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/feedbacks")

public class UserFeedbackController {
    private UserFeedbackService userFeedbackService;

    // create user feedback api
    @PostMapping("/create-feedback")
    public ResponseEntity<UserFeedbackDto> createUserFeedback(@RequestBody UserFeedbackDto userFeedbackDto) {
        UserFeedbackDto userCreated = userFeedbackService.createUserFeeback(userFeedbackDto);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }

    @GetMapping("/get-feedback/{id}")
    public ResponseEntity<UserFeedbackDto> getUserFeedback(@PathVariable Long id) {
        UserFeedbackDto userCreated = userFeedbackService.getUserFeeback(id);
        return ResponseEntity.ok(userCreated);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<UserFeedbackDto>> getAllFeedbacks() {
        List<UserFeedbackDto> feedbacks = userFeedbackService.getAllUserFeebacks();
        return ResponseEntity.ok(feedbacks);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserFeedbackDto> deleteUserFeedbacks(@PathVariable Long id) {
        UserFeedbackDto userfeedback = userFeedbackService.deleteUserFeedback(id);
        return ResponseEntity.ok(userfeedback);
    }
}
