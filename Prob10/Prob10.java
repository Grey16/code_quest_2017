import java.io.*;
import java.util.*;

public class Prob10 {
    static final String[] original = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M", ",", "."};

    public static void main(String[] args) {
        try {
            File f = new File("Prob10.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                int m = Integer.parseInt(br.readLine());
                for(int j = 0; j < m; j++) {
                    String[] input = br.readLine().split("");
                    boolean capsLock = false;
                    for(int k = 1; k < input.length; k++) {
                        if(input[k].equalsIgnoreCase("Q")) {
                            System.out.print("    ");
                        } else if(input[k].equalsIgnoreCase("A")) {
                            capsLock = !capsLock;
                            System.out.print("");
                        } else if(input[k].equalsIgnoreCase("Z")) {
                            System.out.print("");
                        } else if(input[k].equals(" ")) {
                            System.out.print(" ");
                        } else {
                            boolean lowerCase = Character.isLowerCase(input[k].charAt(0));
                            if(lowerCase && !capsLock) {
                                System.out.print(original[find(original, input[k]) - 1].toLowerCase());
                            } else {
                                System.out.print(original[find(original, input[k]) - 1]);
                            }
                        }
                    }
                    System.out.println();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static int find(String[] array, String key) {
        for(int i = 0; i < array.length; i++) {
            if(array[i].equalsIgnoreCase(key)) {
                return i;
            }
        }
        return -1;
    }
}
