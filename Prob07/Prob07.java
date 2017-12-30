import java.io.*;
import java.util.*;
import java.text.*;

public class Prob07 {
    public static void main(String[] args) {
        try {
            File f = new File("Prob07.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                String[] input = br.readLine().split(":");
                String[] data = input[1].split(",");
                int[] hits = new int[4];
                int atBats = 0;
                for(int j = 0; j < data.length; j++) {
                    if(data[j].equals("BB") == false) {
                        atBats++;
                        if(data[j].equals("1B")) {
                            hits[0]++;
                        } else if(data[j].equals("2B")) {
                            hits[1]++;
                        } else if(data[j].equals("3B")) {
                            hits[2]++;
                        } else if(data[j].equals("HR")) {
                            hits[3]++;
                        }
                    }
                }

                DecimalFormat formatter = new DecimalFormat("0.000");
                if(atBats == 0) {
                    System.out.println(input[0] + "=" + formatter.format(0));
                } else {
                    double slg = ((double) ((1 * hits[0]) + (2 * hits[1]) + (3 * hits[2]) + (4 * hits[3]))) / atBats;
                    System.out.println(input[0] + "=" + formatter.format(slg));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
