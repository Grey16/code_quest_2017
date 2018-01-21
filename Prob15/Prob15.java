import java.io.*;
import java.util.*;

public class Prob15 {
    public static void main(String[] args) {
        try {
            File f = new File("Prob15.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String currInput = "";

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                currInput = br.readLine();
                char[] inputArr = currInput.toCharArray();

                int[] numCards = new int[9];
                int mostOfAKind = 0;
                int theKind = 0;
                for(int j = 0; j < inputArr.length; j++) {
                    int card = (int) (inputArr[j] - 48);
                    if(card != 0) {
                        numCards[card - 1]++;
                        if(numCards[card - 1] > mostOfAKind) {
                            mostOfAKind = numCards[card - 1];
                            theKind = card - 1;
                        }
                    }
                }

                String message = null;
                if(mostOfAKind >= 5) {
                    message = " = FIVE OF A KIND";
                } else if(mostOfAKind == 4) {
                    message = " = FOUR OF A KIND";
                }

                if(message == null && mostOfAKind == 3) {
                    boolean fullHouse = false;
                    for(int j = 0; j < numCards.length; j++) {
                        if(j != theKind && numCards[j] >= 2) {
                            fullHouse = true;
                            break;
                        }
                    }
                    if(fullHouse) {
                        message = " = FULL HOUSE";
                    }
                }

                if(message == null) {
                    int longestRun = 0;
                    int currRun = 0;
                    for(int j = 0; j < numCards.length; j++) {
                        if(numCards[j] > 0) {
                            currRun++;
                        } else {
                            if(currRun > longestRun) {
                                longestRun = currRun;
                            }
                            currRun = 0;
                        }
                    }
                    if(currRun > longestRun) {
                        longestRun = currRun;
                    }
                    if(longestRun >= 5) {
                        message = " = STRAIGHT";
                    }
                }

                if(message == null && mostOfAKind == 3) {
                    message = " = THREE OF A KIND";
                }

                if(message == null && mostOfAKind == 2) {
                    boolean twoPair = false;
                    for(int j = 0; j < numCards.length; j++) {
                        if(j != theKind && numCards[j] == 2) {
                            twoPair = true;
                            break;
                        }
                    }
                    if(twoPair) {
                        message = " = TWO PAIR";
                    } else {
                        message = " = PAIR";
                    }
                }

                if(message == null) {
                    int greatestValue = 0;
                    for(int j = 8; j > -1; j--) {
                        if(numCards[j] > 0) {
                            greatestValue = j + 1;
                            break;
                        }
                    }
                    message = " = " + String.valueOf(greatestValue);
                }
                System.out.println(currInput + message);
            }

            br.close();
            fr.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
