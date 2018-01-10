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
                for(int j = 0; j < m; j++) {
                    System.out.println(j + 1);
                    br.readLine();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
