import java.io.*;
import java.util.*;

public class Prob14 {
    public static void main(String[] args) {
        try {
            File f = new File("Prob14.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            String[] output = new String[n];
            HashMap<String, Node> map = new HashMap<String, Node>();
            for(int i = 0; i < n; i++) {
                String[] currInput = br.readLine().split(",");
                String item = currInput[0];
                String parent = currInput[1];
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // shifts strings in String array output from startIndex to the right one place
    // returns index of first empty string in String array output
    public static int shiftRight(String[] output, int startIndex) {

    }

    // linear search to find the index that an item should be inserted at

    // create a 2-D array in which each product is listed with its name, parent, and number of dashes

    // learn how to use java.util.HashMap
}
