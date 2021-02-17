package com.epam.task;

/*При помощи методологии TDD написать приложение "калькулятор". После запуска приложение ожидает на вход строку для
выполнения операций, например на вход может быть подана строка:
2 + 3 * 45.3 * 90 + 20 - 8 / 20 - sqrt4
[в данном случае результат выполнения 12250.6]
Условия:
Каждый оператор это отдельный метод;
Приложение должно автоматически расставлять приоритет выполнения операций, скобки вводить нельзя;
Допустимые операторы +-/*sqrt;
Разделитель десятых только ".";
Приложение должно быть maven приложением (архетип quickstart)
Приложение должно быть размещенно в git репозитории
Важно! Сначала вы пишите тесты, потом логику, тесты отдельным коммитом
Тесты должны быть объедены в сьюты
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    private void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
            String input = reader.readLine();
            input = new SolvingSQRTandReturnAsNumber().solvingSQRTandReturnAsNumber(input);
            List<Lexeme> lexemes = lexicalAnalyzer.lexAnalyse(input);
            LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
            System.out.println(lexemeBuffer.lexemes);
            double resultOfRecursiveDescentParser = new RecursiveDescentParser().expression(lexemeBuffer);
            System.out.format("Ответ: " + "%.1f", resultOfRecursiveDescentParser);
            System.out.println("\nCounter = " + RecursiveDescentParser.counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
