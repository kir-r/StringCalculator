package com.epam.task;

public class RecursiveDescentParser {
    public static int counter = 0;

    public double expression(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        System.out.println("expression: " + lexeme.toString() + " - position: " + lexemes.getPosition());
        if (lexeme.type == LexemeType.END_OF_LINE) {
            return 0;
        }
        else {
            lexemes.back();
//            System.out.println(plusAndMinus(lexemes));
            System.out.println("method expr does return");
            return plusAndMinus(lexemes);
        }
    }

    public double plusAndMinus(LexemeBuffer lexemes) {
        counter++;
        double value = multiplyAndDivision(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            System.out.println("plusAndMinus: " + lexeme.toString() + " - position: " + lexemes.getPosition());
            switch (lexeme.type) {
                case OPERATOR_PLUS:
                    value += multiplyAndDivision(lexemes);
                    break;
                case OPERATOR_MINUS:
                    value -= multiplyAndDivision(lexemes);
                    break;
                default:
                    lexemes.back();
                    System.out.println("value in plusAndMinus = " + value);
                    return value;
            }
        }
    }

    public double multiplyAndDivision(LexemeBuffer lexemes) {
        counter++;
        double value = squaring(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            System.out.println("multiplyAndDivision: " + lexeme.toString() + " - position: " + lexemes.getPosition());
            switch (lexeme.type) {
                case OPERATOR_MULTIPLY:
                    value *= squaring(lexemes);
                    break;
                case OPERATOR_DIVIDE:
                    value /= squaring(lexemes);
                    break;
                default:
                    lexemes.back();
                    System.out.println("value in multiplyAndDivision = " + value);
                    return value;
            }
        }
    }

    public double squaring(LexemeBuffer lexemes) {
        counter++;
        double value = factor(lexemes);
        Lexeme lexeme = lexemes.next();
        System.out.println("squaring: " + lexeme.toString() + " - position: " + lexemes.getPosition());
        if (lexeme.type == LexemeType.OPERATOR_SQUARING) {
            value = Math.sqrt(factor(lexemes));
        }
        lexemes.back();
        System.out.println("value in squaring = " + value);
        return value;
    }
//    2 + 3 * 45.3 * 90 + 20 - 8 / 20 - sqrt4

    public double factor(LexemeBuffer lexemes) {
        counter++;
        Lexeme lexeme = lexemes.next();
        System.out.println("factor: " + lexeme.toString() + " - position: " + lexemes.getPosition());
        if (lexeme.type == LexemeType.NUMBER) {
            System.out.println("lexeme.value in factor = " + lexeme.value);
            return Double.parseDouble(lexeme.value);
        } //else return 0;
        else if (lexeme.type == LexemeType.END_OF_LINE) {
            lexemes.back();
            //System.exit(0);
            return 0;
        } else
            throw new RuntimeException("Trouble in factor method: " + lexeme.value + ", position: " + lexemes.getPosition());
    }
//[Lexeme{type=NUMBER, value='2'}, Lexeme{type=OPERATOR_PLUS, value='+'}, Lexeme{type=NUMBER, value='3'},
// Lexeme{type=OPERATOR_MULTIPLY, value='*'}, Lexeme{type=NUMBER, value='45.3'}, Lexeme{type=OPERATOR_MULTIPLY, value='*'},
// Lexeme{type=NUMBER, value='90'}, Lexeme{type=OPERATOR_PLUS, value='+'}, Lexeme{type=NUMBER, value='20'},
// Lexeme{type=OPERATOR_MINUS, value='-'}, Lexeme{type=NUMBER, value='8'}, Lexeme{type=OPERATOR_DIVIDE, value='/'},
// Lexeme{type=NUMBER, value='20'}, Lexeme{type=OPERATOR_MINUS, value='-'}, Lexeme{type=OPERATOR_SQUARING, value='4'},
// Lexeme{type=END_OF_LINE, value=''}]
}
