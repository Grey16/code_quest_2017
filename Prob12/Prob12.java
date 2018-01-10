import java.io.*;
import java.util.*;

public class Prob12 {
    public static void main(String[] args) {
        try {
            File f = new File("Prob12.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                int m = Integer.parseInt(br.readLine());
                double balance = 0;
                for(int j = 0; j < m; j++) {
                    String temp = "";
                    System.out.println(j + 1);
                    char[] input = br.readLine().toCharArray();
                    boolean firstInput = true;
                    int startIndex = String.valueOf(j).length() + 1;
                    for(int k = startIndex; k < input.length; k++) {
                        if(input[k] == ',') {
                            if(temp.length() != 0) {
                                balance += Double.parseDouble(temp);
                                System.out.println("The current entry: " + temp + " The new balance: " + String.valueOf(balance));
                                temp = "";
                            }
                        } else {
                            temp += String.valueOf(input[k]);
                        }
                    }
                    if(temp.length() != 0) {
                        balance -= Double.parseDouble(temp);
                        System.out.println("The current entry: " + temp + " The new balance: " + String.valueOf(balance));
                    }
                }
                System.out.println((balance / m) * (0.18 / 12));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
