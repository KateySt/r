package com.example.starlight.talent.controller.advice;

import com.example.starlight.talent.TalentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TalentControllerAdvice {
    @ResponseBody
    @ExceptionHandler(TalentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String talentNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }
}
