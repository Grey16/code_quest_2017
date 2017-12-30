import java.io.*;

public class Prob01 {
    private static final String INPUT_FILE_NAME = "Prob01.intxt";

    public static void main(String[] args) {
        try {
            // prepare to read input
            File input = new File(INPUT_FILE_NAME);
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());

            String currLine = null;

            for(int i = 0; i < n; i++) {
                currLine = br.readLine();
                System.out.println(currLine);
                System.out.println(currLine);
            }

            // close everything
            fr.close();
            br.close();

        } catch (Exception e) {
            // handles exceptions
            e.printStackTrace();
        }
    }
}
