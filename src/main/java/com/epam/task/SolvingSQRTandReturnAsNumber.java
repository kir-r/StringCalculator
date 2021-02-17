package com.epam.task;

public class SolvingSQRTandReturnAsNumber {
    public String solvingSQRTandReturnAsNumber(String input) {
        String[] splittedInput = input.split(" ");
        double number;
        for (int i = 0; i < splittedInput.length; i++) {
            if (splittedInput[i].startsWith("sqrt")) {
                number = Math.sqrt(Double.parseDouble(splittedInput[i].substring(4)));
                System.out.println(number);
                splittedInput[i] = Double.toString(number);
            }
        }
        StringBuilder inputStringBuilder = new StringBuilder();
        for (String s : splittedInput) {
            inputStringBuilder.append(s);
        }
        input = inputStringBuilder.toString();
        return input;
    }
}
