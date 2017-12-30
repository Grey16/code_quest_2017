import java.io.*;

public class Prob02 {

    private static final String INPUT_FILE_NAME = "Prob02.in.txt";

    public static void main(String[] args) {
        try {
            File input = new File(INPUT_FILE_NAME);
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());

            String currLine = null;
            for(int i = 0; i < n; i++) {
                currLine = br.readLine();
                String[] parts = currLine.split(" ");
                int letter = Integer.parseInt(parts[1]);
                for(int j = 0; j < parts[0].length(); j++) {
                    if(j != letter) {
                        System.out.print(parts[0].charAt(j));
                    }
                }
                System.out.println();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
