import java.io.*;
import java.util.*;

public class Prob13 {
    // set up values of thresholds
    public static final double HIGH = 0.9 * (1000.0 / 90);
    public static final double EXTRAPOLATE = 0.85 * (1000.0 / 90);
    public static final double LOW = 0.7 * (1000.0 / 90);

    public static void main(String[] args) {
        System.out.println("The low threshold: " + LOW);
        try {
            File f = new File("Prob13.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                // turns input into array of doubles
                String[] currInput = br.readLine().split(" ");
                double[] data = new double[currInput.length];
                for(int j = 0; j < currInput.length; j++) {
                    data[j] = Double.parseDouble(currInput[j]);
                }

                int quality = (int) data[3];
                // quality algorithm
                if(data[2] > HIGH) {
                    quality -= 2;
                } else if(data[2] > EXTRAPOLATE) {
                    // calculate extrapolated values
                    // frame 0 to frame 2
                    double extrap1 = data[2] + ((data[2] - data[0]) / 2);
                    // frame 1 to frame 2
                    double extrap2 = data[2] + (data[2] - data[1]);
                    if(extrap1 > HIGH || extrap2 > HIGH) {
                        quality -= 2;
                    }
                } else if(data[0] < LOW && data[1] < LOW && data[2] < LOW) {
                    quality += 1;
                }

                // output the new quality
                System.out.println(quality);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
