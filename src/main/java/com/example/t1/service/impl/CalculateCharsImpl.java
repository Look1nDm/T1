package com.example.t1.service.impl;

import com.example.t1.model.CalculatorChars;
import com.example.t1.service.CalculateChars;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CalculateCharsImpl implements CalculateChars {

    private final CalculatorChars calculatorChars;

    public CalculateCharsImpl(CalculatorChars calculatorChars) {
        this.calculatorChars = calculatorChars;
    }

    @Override
    public Map<Character, Integer> calculateCharsOnString(String s) {
        calculatorChars.setMap(stringOnMap(s));
        return sortedValuesOnMap(calculatorChars.getMap());
    }

    private static Map<Character, Integer> stringOnMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        return map;
    }
    private static Map<Character, Integer> sortedValuesOnMap(Map<Character, Integer> map) {
        return map.entrySet()
                .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }
}
