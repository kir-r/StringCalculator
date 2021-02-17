package com.epam.task;

import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyzer {

    public List<Lexeme> lexAnalyse(String expressionText) {
        ArrayList<Lexeme> lexemesList = new ArrayList<>();
        int position = 0;
        while (position < expressionText.length()) {
            char currentChar = expressionText.charAt(position);
            switch (currentChar) {
                case '+':
                    lexemesList.add(new Lexeme(LexemeType.OPERATOR_PLUS, currentChar));
                    position++;
                    continue;
                case '-':
                    lexemesList.add(new Lexeme(LexemeType.OPERATOR_MINUS, currentChar));
                    position++;
                    continue;
                case '*':
                    lexemesList.add(new Lexeme(LexemeType.OPERATOR_MULTIPLY, currentChar));
                    position++;
                    continue;
                case '/':
                    lexemesList.add(new Lexeme(LexemeType.OPERATOR_DIVIDE, currentChar));
                    position++;
                    continue;
                default:
                    if (currentChar <= '9' && currentChar >= '0' || currentChar == '.') {   //???
                        StringBuilder stringBuilder = new StringBuilder();
                        do {
                            stringBuilder.append(currentChar);
                            position++;
                            if (position >= expressionText.length()) {
                                break;
                            }
                            currentChar = expressionText.charAt(position);
                        } while (currentChar <= '9' && currentChar >= '0' || currentChar == '.');
                        lexemesList.add(new Lexeme(LexemeType.NUMBER, stringBuilder.toString()));
                    } else {
                        if (currentChar != ' ') {
                            throw new RuntimeException("Wrong character: " + currentChar);
                        }
                        position++;
                    }
            }
        }
        lexemesList.add(new Lexeme(LexemeType.END_OF_LINE, ""));
        return lexemesList;
    }
}

