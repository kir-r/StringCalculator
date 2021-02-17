package com.epam.task;

import org.junit.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecursiveDescentParserTest {

    private static RecursiveDescentParser recursiveDescentParser;
    private static LexemeBuffer lexemebuffer;
    private static List<Lexeme> lexemes;

    @BeforeAll
    static void initTest() {
        recursiveDescentParser = new RecursiveDescentParser();
        lexemes = new ArrayList<>();
        lexemes.add(new Lexeme(LexemeType.NUMBER, '1'));
        lexemes.add(new Lexeme(LexemeType.OPERATOR_PLUS, '+'));
        lexemes.add(new Lexeme(LexemeType.NUMBER, '1'));
        lexemes.add(new Lexeme(LexemeType.OPERATOR_MINUS, '-'));
        lexemes.add(new Lexeme(LexemeType.NUMBER, '1'));
        lexemes.add(new Lexeme(LexemeType.OPERATOR_MULTIPLY, '*'));
        lexemes.add(new Lexeme(LexemeType.NUMBER, '1'));
        lexemes.add(new Lexeme(LexemeType.OPERATOR_DIVIDE, '/'));
        lexemes.add(new Lexeme(LexemeType.NUMBER, '1'));
        lexemes.add(new Lexeme (LexemeType.END_OF_LINE, ""));
        lexemebuffer = new LexemeBuffer(lexemes);
    }

    @After
    public void afterAll() {
        recursiveDescentParser = null;
        lexemes = null;
        lexemebuffer = null;
    }

    @Test
    void expression() {
        assertEquals(recursiveDescentParser.expression(lexemebuffer), 1, 0.01);
    }
}