import java.io.*;
import java.util.*;

public class Prob08 {
    public static void main(String[] args) {
        try {
            File f = new File("Prob08.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                double[] data = new double[2];
                for(int j = 0; j < input.length; j++) {
                    data[j] = Double.parseDouble(input[j]);
                }
                double current = (data[0] * 1000000) / data[1];
                int days = (int) (current / 24);
                current %= 24.0;
                int hours = (int) current;
                current %= 1.0;
                current *= 60;
                int minutes = (int) current;
                current %= 1.0;
                current *= 60;
                int seconds = (int) Math.round(current);
                if(seconds == 60) {
                    seconds = 0;
                    minutes += 1;
                }
                if(minutes == 60) {
                    minutes = 0;
                    hours += 1;
                }
                if(hours == 24) {
                    hours = 0;
                    days += 1;
                }
                System.out.println("Time to Mars: " + days + " days," + hours + " hours," + minutes + " minutes," + seconds + " seconds");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
