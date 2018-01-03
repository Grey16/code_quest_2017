import java.io.*;
import java.util.*;

public class Prob09 {
    public static void main(String[] args) {
        try {
            File f = new File("Prob09.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                char[] message = br.readLine().toCharArray();
                char[] keyword = br.readLine().toCharArray();
                int spaces = 0;
                for(int j = 0; j < message.length; j++) {
                    if(message[j] != ' ') {
                        message[j] = (char) ((((message[j] - 'A') + (keyword[(j - spaces) % keyword.length] - 'A')) % 26) + 65);
                    } else {
                        spaces++;
                    }
                }

                System.out.println(new String(message));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
