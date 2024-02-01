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
    public Map<Character, Integer> calculateCharsOnString(String s) {
        if (validString(s)) {
            Map<Character, Integer> map = new HashMap<>(stringOnMap(s));
            return sortedValuesOnMap(map);
        } else {
            throw new NoValidStringException("Введите корректные данные");
        }
    }

    private static boolean validString(String s) {
        return s != null && !s.trim().isEmpty();
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
