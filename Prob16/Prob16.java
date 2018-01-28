import java.io.*;
import java.util.*;

public class Prob16 {

    public static String[] operators;
    public static String[] operands;
    public static boolean[] operatorsUsed;
    public static boolean[] operandsUsed;
    public static boolean solutionFound;
    public static int targetValue;

    public static void main(String[] args) {
        try {
            File f = new File("Prob16.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                String[] currInput = br.readLine().split(":");
                targetValue = Integer.parseInt(currInput[0]);

                String[] integersAndOperators = currInput[1].split(" ");
                int numOperators = integersAndOperators.length / 2;
                int numOperands = numOperators + 1;
                operators = new String[numOperators];
                operands = new String[numOperands];
                operatorsUsed = new boolean[numOperators];
                operandsUsed = new boolean[numOperands];

                Arrays.fill(operatorsUsed, false);
                Arrays.fill(operandsUsed, false);

                int operatorsIndex = 0;
                int operandsIndex = 0;
                for(int j = 0; j < integersAndOperators.length; j++) {
                    try {
                        Integer.parseInt(integersAndOperators[j]);
                        operands[operandsIndex++] = integersAndOperators[j];
                    } catch(NumberFormatException e) {
                        operators[operatorsIndex++] = integersAndOperators[j];
                    }
                }
                System.out.println(Arrays.toString(operands));
                System.out.println(Arrays.toString(operators));

                solutionFound = false;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static final String ADDITION = "+";
    public static final String SUBTRACTION = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";
    public static void solveEquation(LinkedList<String> equation) {
        int currentIndex = 0;
        while(currentIndex < equation.size()) {
            String current = equation.get(currentIndex);
            if(current.equals(MULTIPLICATION) || current.equals(DIVISION)) {
                int firstOperand = Integer.parseInt(equation.get(currentIndex - 1));
                int numerator = firstOperand;
                int denominator = 1;

                boolean finished = false;

                while(current.equals(MULTIPLICATION) || current.equals(DIVISION) && !finished) {
                    int nextOperand = Integer.parseInt(equation.remove(currentIndex + 1));
                    equation.remove(currentIndex);

                    if(current.equals(MULTIPLICATION)) {
                        numerator *= nextOperand;
                    } else if(current.equals(DIVISION)) {
                        denominator *= nextOperand;
                    }

                    if(currentIndex > equation.size()) {
                        finished = true;
                    } else {
                        current = equation.get(currentIndex);
                    }
                }

                // get rid of first operand
                equation.remove(currentIndex - 1);

                if(denominator == 0) return;

                int remainder = numerator % denominator;

                if(remainder != 0) {
                    return;
                } else {
                    int result = numerator / denominator;
                    equation.add(currentIndex - 1, String.valueOf(result));
                }
            } else {
                currentIndex++;
            }

            if(current.equals(ADDITION) || current.equals(SUBTRACTION)) {
                int firstOperand = Integer.parseInt(equation.get(currentIndex - 1));
                String operator = equation.remove(currentIndex);
                int secondOperand = Integer.parseInt(equation.remove(currentIndex + 1));

                int result;
                if(operator.equals(ADDITION)) {
                    result = firstOperand + secondOperand;
                } else {
                    result = firstOperand - secondOperand;
                }
                equation.remove(currentIndex - 1);
                equation.add(currentIndex - 1, String.valueOf(result));
            } else {
                currentIndex++;
            }
        }
        int result = Integer.parseInt(equation.pop());
        if(result == targetValue) {
            solutionFound = true;
        }
    }
}
