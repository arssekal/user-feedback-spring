package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserFeedbackDto;

public interface UserFeedbackService {
    UserFeedbackDto createUserFeeback(UserFeedbackDto userFeedbackDto);
    UserFeedbackDto getUserFeeback(Long id);
    UserFeedbackDto updateUserFeeback(Long id, UserFeedbackDto userFeedbackDto);
    UserFeedbackDto deleteUserFeedback(Long id);
    List<UserFeedbackDto> getAllUserFeebacks();
}
