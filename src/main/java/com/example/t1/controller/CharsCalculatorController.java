package com.example.t1.controller;

import com.example.t1.service.CharsCalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/v1/chars/calculator")
public class CharsCalculatorController {

    private final CharsCalculatorService calculateCharsService;

    public CharsCalculatorController(CharsCalculatorService calculateChars) {
        this.calculateCharsService = calculateChars;
    }

    @GetMapping("/{string}")
    public Map<Character, Integer> calculateCharsOnString(@PathVariable String string) {
        System.out.println("прошел запрос");
        return calculateCharsService.calculateCharsInString(string);
    }
}
