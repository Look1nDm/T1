package com.example.t1.controller;

import com.example.t1.service.CalculateChars;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CalculatorCharsController {

    private final CalculateChars calculateChars;

    public CalculatorCharsController(CalculateChars calculateChars) {
        this.calculateChars = calculateChars;
    }

    @GetMapping("/{s}")
    public Map<Character, Integer> calculateCharsOnString(@PathVariable String s) {
        return calculateChars.calculateCharsOnString(s);
    }
}
