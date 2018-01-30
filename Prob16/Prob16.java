import java.io.*;
import java.util.*;

public class Prob16 {

    public static String[] operators;
    public static String[] operands;
    public static String[] equation;
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

                equation = new String[numOperators + numOperands];
                solutionFound = false;
                fillEquation(0);

                if(solutionFound) {
                    System.out.println("TRUE");
                } else {
                    System.out.println("FALSE");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void fillEquation(int currentPosition) {
        if(currentPosition == equation.length) {
            LinkedList<String> equationList = new LinkedList<String>();
            for(int i = 0; i < equation.length; i++) {
                equationList.add(equation[i]);
            }
            solveEquation(equationList);
        } else {
            if(currentPosition % 2 == 0) {
                for(int i = 0; i < operands.length; i++) {
                    if(!operandsUsed[i]) {
                        operandsUsed[i] = true;
                        equation[currentPosition] = operands[i];
                        fillEquation(currentPosition + 1);
                        operandsUsed[i] = false;
                    }
                    if(solutionFound) {
                        break;
                    }
                }
            } else {
                for(int i = 0; i < operators.length; i++) {
                    if(!operatorsUsed[i]) {
                        operatorsUsed[i] = true;
                        equation[currentPosition] = operators[i];
                        fillEquation(currentPosition + 1);
                        operatorsUsed[i] = false;
                    }
                    if(solutionFound) {
                        break;
                    }
                }
            }
        }
    }

    public static final String ADDITION = "+";
    public static final String SUBTRACTION = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";
    public static void solveEquation(LinkedList<String> equationList) {
        int currentIndex = 0;
        while(currentIndex < equationList.size()) {
            String current = equationList.get(currentIndex);
            if(current.equals(MULTIPLICATION) || current.equals(DIVISION)) {
                int firstOperand = Integer.parseInt(equationList.get(currentIndex - 1));
                int numerator = firstOperand;
                int denominator = 1;

                boolean finished = false;

                while(current.equals(MULTIPLICATION) || current.equals(DIVISION) && !finished) {
                    int nextOperand = Integer.parseInt(equationList.remove(currentIndex + 1));
                    equationList.remove(currentIndex);

                    if(current.equals(MULTIPLICATION)) {
                        numerator *= nextOperand;
                    } else if(current.equals(DIVISION)) {
                        denominator *= nextOperand;
                    }

                    if(currentIndex > equationList.size()) {
                        finished = true;
                    } else {
                        current = equationList.get(currentIndex);
                    }
                }

                // get rid of first operand
                equationList.remove(currentIndex - 1);

                if(denominator == 0) return;

                int remainder = numerator % denominator;

                if(remainder != 0) {
                    return;
                } else {
                    int result = numerator / denominator;
                    equationList.add(currentIndex - 1, String.valueOf(result));
                }
            } else {
                currentIndex++;
            }

            if(current.equals(ADDITION) || current.equals(SUBTRACTION)) {
                int firstOperand = Integer.parseInt(equationList.get(currentIndex - 1));
                String operator = equationList.remove(currentIndex);
                int secondOperand = Integer.parseInt(equationList.remove(currentIndex + 1));

                int result;
                if(operator.equals(ADDITION)) {
                    result = firstOperand + secondOperand;
                } else {
                    result = firstOperand - secondOperand;
                }
                equationList.remove(currentIndex - 1);
                equationList.add(currentIndex - 1, String.valueOf(result));
            } else {
                currentIndex++;
            }
        }
        int result = Integer.parseInt(equationList.pop());
        if(result == targetValue) {
            solutionFound = true;
        }
    }
}
