package com.example.demo.mapper;

import com.example.demo.dto.UserFeedbackDto;
import com.example.demo.enntity.UserFeedback;

public class UserMapper {
    public static UserFeedback mapToUserFeedback(UserFeedbackDto userFeedbackDto) {
        return new UserFeedback(
            userFeedbackDto.getId(),
            userFeedbackDto.getName(),
            userFeedbackDto.getEmail(),
            userFeedbackDto.getPhone(),
            userFeedbackDto.getSatisfaction(),
            userFeedbackDto.getHeardAbout(),
            userFeedbackDto.getDate()
        );
    }
    public static UserFeedbackDto mapToUserFeedbackDto(UserFeedback userFeedback) {
        return new UserFeedbackDto(
            userFeedback.getId(),
            userFeedback.getName(),
            userFeedback.getEmail(),
            userFeedback.getPhone(),
            userFeedback.getSatisfaction(),
            userFeedback.getHeardAbout(),
            userFeedback.getDate()
        );
    }

}
