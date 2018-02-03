import java.io.*;
import java.util.*;

public class Prob16 {
    public static String[] operands;
    public static String[] operators;
    public static String[] equation;

    public static boolean[] operandsUsed;
    public static boolean[] operatorsUsed;

    public static int targetResult;

    public static boolean solutionFound;

    public static final String ADDITION = "+";
    public static final String SUBTRACTION = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";

    public static void main(String[] args) {
        try {
            File f = new File("Prob16.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int numTestCases = Integer.parseInt(br.readLine());
            String[] currInput = null;
            String[] symbols = null;
            int numOperands;
            int numOperators;
            for(int i = 0; i < numTestCases; i++) {
                currInput = br.readLine().split(":");
                targetResult = Integer.parseInt(currInput[0]);

                symbols = currInput[1].split(" ");
                numOperands = (symbols.length / 2) + 1;
                numOperators = numOperands - 1;
                operands = new String[numOperands];
                operators = new String[numOperators];

                int operandIndex = 0;
                int operatorIndex = 0;
                for(int j = 0; j < symbols.length; j++) {
                    try {
                        Integer.parseInt(symbols[j]);
                        operands[operandIndex] = symbols[j];
                        operandIndex++;
                    } catch(NumberFormatException e) {
                        operators[operatorIndex] = symbols[j];
                        operatorIndex++;
                    }
                }

                operandsUsed = new boolean[numOperands];
                operatorsUsed = new boolean[numOperators];
                Arrays.fill(operandsUsed, false);
                Arrays.fill(operatorsUsed, false);

                solutionFound = false;
                equation = new String[numOperands + numOperators];
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
            if(solutionFound) {
                return;
            }
        } else {
            if(currentPosition % 2 == 0) {
                for(int i = 0; i < operands.length; i++) {
                    if(!operandsUsed[i]) {
                        equation[currentPosition] = operands[i];
                        operandsUsed[i] = true;
                        fillEquation(currentPosition + 1);
                        operandsUsed[i] = false;
                    }
                }
            } else {
                for(int i = 0; i < operators.length; i++) {
                    if(!operatorsUsed[i]) {
                        equation[currentPosition] = operators[i];
                        operatorsUsed[i] = true;
                        fillEquation(currentPosition + 1);
                        operatorsUsed[i] = false;
                    }
                }
            }
        }
    }

    public static void solveEquation(LinkedList<String> equationList) {
        int currentIndex = 0;
        String currentSymbol;
        // handles all multiplication and division
        while(currentIndex < equationList.size()) {
            currentSymbol = equationList.get(currentIndex);
            if(currentSymbol.equals(MULTIPLICATION) || currentSymbol.equals(DIVISION)) {
                String firstOperand = equationList.get(currentIndex - 1);
                int numerator = Integer.parseInt(firstOperand);
                int denominator = 1;
                while(currentSymbol.equals(MULTIPLICATION) || currentSymbol.equals(DIVISION)) {
                    equationList.remove(currentIndex);
                    int secondOperand = Integer.parseInt(equationList.remove(currentIndex));
                    if(currentSymbol.equals(MULTIPLICATION)) {
                        numerator *= secondOperand;
                    } else {
                        denominator *= secondOperand;
                    }
                    if(currentIndex < equationList.size()) {
                        currentSymbol = equationList.get(currentIndex);
                    } else {
                        break;
                    }
                }

                if(denominator == 0 || numerator % denominator != 0) {
                    return;
                } else {
                    int result = numerator / denominator;
                    equationList.remove(currentIndex - 1);
                    equationList.add(currentIndex - 1, String.valueOf(result));
                }
            } else {
                currentIndex++;
            }
        }

        currentIndex = 0;
        while(currentIndex < equationList.size()) {
            currentSymbol = equationList.get(currentIndex);
            if(currentSymbol.equals(ADDITION) || currentSymbol.equals(SUBTRACTION)) {
                int firstOperand = Integer.parseInt(equationList.get(currentIndex - 1));
                while(currentSymbol.equals(ADDITION) || currentSymbol.equals(SUBTRACTION)) {
                    equationList.remove(currentIndex);
                    int secondOperand = Integer.parseInt(equationList.remove(currentIndex));
                    if(currentSymbol.equals(ADDITION)) {
                        firstOperand += secondOperand;
                    } else {
                        firstOperand -= secondOperand;
                    }
                    if(currentIndex < equationList.size()) {
                        currentSymbol = equationList.get(currentIndex);
                    } else {
                        break;
                    }
                }
                equationList.remove(currentIndex - 1);
                equationList.add(currentIndex - 1, String.valueOf(firstOperand));
            } else {
                currentIndex++;
            }
        }

        if(Integer.parseInt(equationList.pop()) == targetResult) {
            solutionFound = true;
        }
    }
}
