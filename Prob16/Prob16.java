import java.io.*;
import java.util.*;

public class Prob16 {

    public static String[] operators;
    public static String[] operands;

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
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
