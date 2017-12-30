import java.io.*;

public class Prob04 {

    private static final String INPUT_FILE_NAME = "Prob04.in.txt";

    public static void main(String[] args) {
        try {
            File f = new File(INPUT_FILE_NAME);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());

            for(int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                System.out.println(num + " = " + fibonacci(num));
            }

            br.close();
            fr.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static long fibonacci(int num) {
        long[] fib = {0, 1};

        if(num == 1) {
            return 0;
        } else if(num == 2) {
            return 1;
        } else {
            for(int i = 0; i < num - 2; i++) {
                long temp = fib[1];
                fib[1] += fib[0];
                fib[0] = temp;
            }
            return fib[1];
        }
    }
}
