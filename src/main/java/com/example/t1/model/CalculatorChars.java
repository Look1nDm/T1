package com.example.t1.model;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CalculatorChars {
    private Map<Character, Integer> map;

    public Map<Character, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Character, Integer> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "CalculatorChars{" +
                "map=" + map +
                '}';
    }
}
