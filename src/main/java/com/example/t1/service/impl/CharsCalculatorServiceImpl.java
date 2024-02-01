package com.example.t1.service.impl;

import com.example.t1.exception.NoValidStringException;
import com.example.t1.service.CharsCalculatorService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CharsCalculatorServiceImpl implements CharsCalculatorService {

    @Override
    public Map<Character, Integer> calculateCharsInString(String s) {
        if (validString(s)) {
            Map<Character, Integer> map = new HashMap<>(countChars(s));
            return sort(map);
        } else {
            throw new NoValidStringException("Введите корректные данные");
        }
    }

    private static boolean validString(String s) {
        return s != null && !s.trim().isEmpty();
    }

    private static Map<Character, Integer> countChars(String s) {
        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        character -> character,
                        LinkedHashMap::new,
                        Collectors.summingInt(c -> 1)
                ));
    }

    private static Map<Character, Integer> sort(Map<Character, Integer> map) {
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
