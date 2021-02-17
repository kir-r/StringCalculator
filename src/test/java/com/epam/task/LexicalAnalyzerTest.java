package com.epam.task;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LexicalAnalyzerTest {

    private static LexicalAnalyzer lexicalAnalyzer;

    @BeforeAll
    static void initTest() {
        lexicalAnalyzer = new LexicalAnalyzer();
    }

    @After
    public void afterTest() {
        lexicalAnalyzer = null;
    }

    @Test
    void lexAnalyse() {
        List<Lexeme> lexemes = lexicalAnalyzer.lexAnalyse("1 + 2 - 3");
        assertEquals(lexemes.size(), 6);
    }
}