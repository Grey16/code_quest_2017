import java.io.*;
import java.util.*;
import java.lang.*;

public class Prob05 {
    public static void main(String[] args) {
        try {
            File f = new File("Prob05.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                String[] lastYear = br.readLine().split(",");
                String[] thisYear = br.readLine().split(",");
                sort(lastYear, thisYear);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void sort(String[] lastYear, String[] thisYear) {
        Arrays.sort(lastYear);
        Arrays.sort(thisYear);

        ArrayList<String> onlyLast = new ArrayList<String>(0);
        ArrayList<String> onlyThis = new ArrayList<String>(0);
        ArrayList<String> both = new ArrayList<String>(0);

        for(int i = 0; i < lastYear.length; i++) {
            if(Arrays.binarySearch(thisYear, lastYear[i]) < 0) {
                onlyLast.add(lastYear[i]);
            } else {
                both.add(lastYear[i]);
            }
        }

        for(int i = 0; i < thisYear.length; i++) {
            if(Arrays.binarySearch(lastYear, thisYear[i]) < 0) {
                onlyThis.add(thisYear[i]);
            }
        }

        printThis(onlyLast);
        printThis(both);
        printThis(onlyThis);
    }

    public static void printThis(ArrayList list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if(i + 1 != list.size()) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
