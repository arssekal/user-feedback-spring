package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.enntity.UserFeedback;

public interface UserFeedbackRepos extends JpaRepository<UserFeedback, Long> {
} 