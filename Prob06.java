import java.io.*;
import java.util.*;

public class Prob06 {

    static final String[] alpha = {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliet", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "Xray", "Yankee", "Zulu"};

    public static void main(String[] args) {
        try {
            File f = new File("Prob06.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                int m = Integer.parseInt(br.readLine());
                for(int j = 0; j < m; j++) {
                    String input = br.readLine().toUpperCase();
                    for(int k = 0; k < input.length(); k++) {
                        char c = input.charAt(k);
                        if(c != 32) {
                            System.out.print(alpha[c - 'A']);
                            if(k + 1 < input.length() && input.charAt(k + 1) != 32) {
                                System.out.print("-");
                            }
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
