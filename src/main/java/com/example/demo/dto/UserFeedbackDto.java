package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserFeedbackDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String satisfaction;
    private String heardAbout;
    private String date;

}

