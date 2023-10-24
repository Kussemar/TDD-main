package dk.lyngby.kata2;

import java.util.regex.Pattern;

public class StringCalculator {
    public static void main(String[] args) {
        System.out.println(add("//;\n1;3"));
        System.out.println(add("//|\n1|2|3"));
        System.out.println(add("//sep\n2sep5"));

    }

    public static int add(String numbers) {
        int sum = 0;
        StringBuilder negativeNumbers = new StringBuilder();
        String errorMessage = null;

        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");

            if (delimiterIndex != -1) {
                String delimiterLine = numbers.substring(2, delimiterIndex);
                String numbersToParse = numbers.substring(delimiterIndex + 1);

                String[] tokens = numbersToParse.split(Pattern.quote(delimiterLine));

                for (String token : tokens) {
                    int num = Integer.parseInt(token);

                    if (num < 0) {
                        if (!negativeNumbers.isEmpty()) {
                            negativeNumbers.append(", ");
                        }
                        negativeNumbers.append(num);
                    } else if (num <= 1000) {
                        sum += num;
                    }
                }
            } else {
                errorMessage = "Invalid input format";
            }
        } else {
            if (!numbers.isEmpty()) {
                if (numbers.endsWith(",")) {
                    errorMessage = "Separator not allowed at the end";
                } else {
                    String[] tokens = numbers.split("[,\n]");

                    for (String token : tokens) {
                        int num = Integer.parseInt(token);

                        if (num < 0) {
                            if (negativeNumbers.length() > 0) {
                                negativeNumbers.append(", ");
                            }
                            negativeNumbers.append(num);
                        } else if (num <= 1000) {
                            sum += num;
                        }
                    }
                }
            }
        }

        if (negativeNumbers.length() > 0) {
            if (errorMessage == null) {
                errorMessage = "Negative number(s) not allowed: " + negativeNumbers.toString();
            } else {
                errorMessage += "\nNegative number(s) not allowed: " + negativeNumbers.toString();
            }
        }

        if (errorMessage != null) {
            throw new IllegalArgumentException(errorMessage);
        }

        return sum;
    }
}