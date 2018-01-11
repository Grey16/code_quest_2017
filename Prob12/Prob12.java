import java.io.*;
import java.util.*;
//Need to debug; Problems with double imprecision and final output

public class Prob12 {
    public static void main(String[] args) {
        try {
            File f = new File("Prob12.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                int m = Integer.parseInt(br.readLine());
                double dailyBalance = 0;
                double balance = 0;
                for(int j = 0; j < m; j++) {
                    String temp = "";
                    char[] input = br.readLine().toCharArray();
                    boolean firstInput = true;
                    int startIndex = String.valueOf(j).length() + 1;
                    for(int k = startIndex; k < input.length; k++) {
                        if(input[k] == ',') {
                            if(temp.length() != 0) {
                                dailyBalance += Double.parseDouble(temp);
                                temp = "";
                            }
                        } else {
                            temp += String.valueOf(input[k]);
                        }
                    }
                    if(temp.length() != 0) {
                        dailyBalance -= Double.parseDouble(temp);
                    }
                    balance += dailyBalance;
                }
                double output = (balance / m) * (0.18 / 12);
                output = (double) Math.round(output * 100d) / 100d;
                System.out.println("$" + String.valueOf(output));

            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
