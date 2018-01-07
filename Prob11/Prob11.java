import java.io.*;
import java.util.*;

public class Prob11 {
    public static void main(String[] args) {
        try {
            File f = new File("Prob11.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                char[] ch = br.readLine().toCharArray();
                String word = "";
                for(int j = 0; j < ch.length; j++) {
                    if((ch[j] > 64 && ch[j] < 91) || (ch[j] > 96 && ch[j] < 123)) {
                        word += String.valueOf(ch[j]);
                    } else {
                        if(!word.equals("")) {
                            reverse(word, ch, j);
                            word = "";
                        }
                    }
                }
                if(!word.equals("")) {
                    reverse(word, ch, ch.length);
                }
                System.out.println(String.valueOf(ch));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void reverse(String word, char[] ch, int index) {
        char[] letters = word.toCharArray();
        for(int k = 0; k < letters.length; k++) {
            int m = letters.length - k - 1;
            if(m <= k) {
                break;
            } else {
                if(Character.isUpperCase(letters[k]) == Character.isUpperCase(letters[m])) {
                    char c = letters[k];
                    letters[k] = letters[m];
                    letters[m] = c;
                } else {
                    char c = letters[k];
                    letters[k] = letters[m];
                    letters[m] = c;
                    if(Character.isUpperCase(letters[m])) {
                        letters[k] = Character.toUpperCase(letters[k]);
                        letters[m] = Character.toLowerCase(letters[m]);
                    } else {
                        letters[k] = Character.toLowerCase(letters[k]);
                        letters[m] = Character.toUpperCase(letters[m]);
                    }
                }
            }
        }

        int currIndex = 0;
        for(int i = index - letters.length; i < index; i++) {
            ch[i] = letters[currIndex];
            currIndex++;
        }
    }
}
