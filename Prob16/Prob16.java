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
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
