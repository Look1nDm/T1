package com.example.t1.service.impl;

import com.example.t1.exception.NoValidStringException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CharsCalculatorServiceImplTest {

    CharsCalculatorServiceImpl charsCalculatorService = new CharsCalculatorServiceImpl();

    String testString = "assfffdddd";

    String testStringIsEmpty = "    ";
    String testStringIsNull = null;
    Map<Character, Integer> expectedMap = new LinkedHashMap<>();

    @BeforeEach
    void setSettings() {
        expectedMap.put('d', 4);
        expectedMap.put('f', 3);
        expectedMap.put('s', 2);
        expectedMap.put('a', 1);
    }

    @Test
    public void calculateCharsOnStringTest() {
        Map<Character, Integer> actualMap = charsCalculatorService.calculateCharsOnString(testString);
        assertEquals(expectedMap, actualMap);
    }

    @Test
    public void calculateCharsOnStringIsNotNullTest() {
        Map<Character, Integer> actualMap = charsCalculatorService.calculateCharsOnString(testString);
        assertNotNull(actualMap);
    }

    @Test
    public void calculateCharsOnStringIsNullTest() {
        assertThrows(NoValidStringException.class,
                () -> charsCalculatorService.calculateCharsOnString(testStringIsNull));
    }
    @Test
    public void calculateCharsOnStringIsEmptyTest(){
        assertThrows(NoValidStringException.class,
                () -> charsCalculatorService.calculateCharsOnString(testStringIsEmpty));
    }
}
