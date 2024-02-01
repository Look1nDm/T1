package com.example.t1;

import com.example.t1.controller.CharsCalculatorController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class T1ApplicationTests {

    @Autowired
    private CharsCalculatorController charsCalculatorController;
    @Test
    void contextLoads() {
        Assertions.assertThat(charsCalculatorController).isNotNull();
    }
}
