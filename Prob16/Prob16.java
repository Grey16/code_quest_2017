import java.io.*;
import java.util.*;

public class Prob16 {

    public static String[] operators;
    public static String[] operands;
    public static boolean[] operatorsUsed;
    public static boolean[] operandsUsed;
    public boolean solutionFound;

    public static void main(String[] args) {
        try {
            File f = new File("Prob16.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                String[] currInput = br.readLine().split(":");
                int result = Integer.parseInt(currInput[0]);

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

    public static final String MULTIPLICATION = "*";
    public static void solveEquation(LinkedList<String> equation) {
        int currentIndex = 0;
        while(currentIndex < equation.size()) {
            String current = equation.get(currentIndex);
            if(current.equals(MULTIPLICATION) || current.equals(DIVISION)) {
                int numerator = Integer.parseInt(equation.get(currentIndex - 1));
                int denominator = 1;

                int nextOperand = Integer.parseInt(equation.get(currentIndex + 1));
            }
        }
    }
}
