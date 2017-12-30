import java.io.*;

public class Prob03 {

    private static final String INPUT_FILE_NAME = "Prob03.in.txt";

    public static void main(String[] args) {
        try {
            File f = new File(INPUT_FILE_NAME);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());

            String currLine = null;
            for(int i = 0; i < n; i++) {
                currLine = br.readLine();
                String[] parts = currLine.split(" ");
                int num1 = Integer.parseInt(parts[0]);
                int num2 = Integer.parseInt(parts[1]);
                System.out.print((num1 + num2) + " ");
                System.out.println(num1 * num2);
            }

            br.close();
            fr.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
