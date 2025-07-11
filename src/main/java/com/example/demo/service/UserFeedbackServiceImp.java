package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserFeedbackDto;
import com.example.demo.enntity.UserFeedback;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserFeedbackRepos;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UserFeedbackServiceImp implements UserFeedbackService {
    private UserFeedbackRepos userFeedbackRepository;

    @Override
    public UserFeedbackDto createUserFeeback(UserFeedbackDto userFeedbackDto) {
        UserFeedback userFeedback = UserMapper.mapToUserFeedback(userFeedbackDto);
        UserFeedback savedUser = userFeedbackRepository.save(userFeedback);    
        return UserMapper.mapToUserFeedbackDto(savedUser);
    }

    @Override
    public UserFeedbackDto getUserFeeback(Long id) {
        UserFeedback userFeedback = userFeedbackRepository
                                    .findById(id)
                                    .orElseThrow(() -> new RuntimeException("the user feedback not found with the given id: "+ id));
        return UserMapper.mapToUserFeedbackDto(userFeedback);
    }

    @Override
    public UserFeedbackDto updateUserFeeback(Long id, UserFeedbackDto updatedUserFeedbackDto) {
        UserFeedback userFeedback = userFeedbackRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("the user feedback not found with the given id: "+ id));
        userFeedback.setName(updatedUserFeedbackDto.getName());
        userFeedback.setEmail(updatedUserFeedbackDto.getEmail());
        userFeedback.setPhone(updatedUserFeedbackDto.getPhone());
        userFeedback.setSatisfaction(updatedUserFeedbackDto.getSatisfaction());
        userFeedback.setHeardAbout(updatedUserFeedbackDto.getHeardAbout());
        UserFeedback savedUser = userFeedbackRepository.save(userFeedback);
        return UserMapper.mapToUserFeedbackDto(savedUser);
    }

    @Override
    public List<UserFeedbackDto> getAllUserFeebacks() {
        List<UserFeedbackDto> userFeedbacks = userFeedbackRepository.findAll()
                                              .stream()
                                              .map((user) -> UserMapper.mapToUserFeedbackDto(user))
                                              .collect(Collectors.toList());
        return userFeedbacks;
    }
    @Override
    public UserFeedbackDto deleteUserFeedback(Long id) {
        UserFeedback userFeedback = userFeedbackRepository
                                .findById(id)
                                .orElseThrow(() -> new RuntimeException("the user feedback not found with the given id: "+ id));
        userFeedbackRepository.delete(userFeedback);
        return UserMapper.mapToUserFeedbackDto(userFeedback);
    }
}
