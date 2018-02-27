import java.io.*;
import java.util.*;
// possibly implement using a Tree
public class Prob17 {
    public static String[][] board;

    public static void main(String[] args) {

        try {
            File f = new File("Prob17.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int numTestCases = Integer.parseInt(br.readLine());
            for(int i = 0; i < numTestCases; i++) {
                board = new String[3][3];

                int numX = 0;
                int numO = 0;
                for(int j = 0; j < board.length; j++) {
                    board[j] = br.readLine().split("");
                    for(String square : board[j]) {
                        if(square.equals("X")) {
                            numX++;
                        } else if(square.equals("O")) {
                            numO++;
                        }
                    }
                }

                boolean myTurn;
                if(numO == numX) {
                    myTurn = true;
                } else {
                    myTurn = false;
                }

                Node root = new Node(board, myTurn);
                System.out.println(root.countBlanks());

            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static class Node {
        String[][] board;
        boolean myTurn;
        ArrayList<Node> children;

        public Node(String[][] inputBoard, boolean inputTurn) {
            board = inputBoard;
            myTurn = inputTurn;
            children = new ArrayList<Node>();
        }

        public int countBlanks() {
            int blanks = 0;
            for(String[] row : board) {
                for(String square : row) {
                    if(square.equals("*")) {
                        blanks++;
                    }
                }
            }
            return blanks;
        }

        public int checkWin() {
            for(int i = 0; i < board.length; i++) {
                boolean rowWin = true;
                String firstSymbolInRow = board[i][0];
                for(String symbol : board[i]) {
                    if(!symbol.equals(firstSymbolInRow)) {
                        rowWin = false;
                        break;
                    }
                }
                if(rowWin) {
                    if(firstSymbolInRow.equals("X")) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }

            for(int i = 0; i < board[0].length; i++) {
                boolean columnWin = true;
                String firstSymbolInColumn = board[0][i];
                for(int j = 0; j < board.length; j++) {
                    if(!board[j][i].equals(firstSymbolInColumn)) {
                        columnWin = false;
                        break;
                    }
                }
                if(columnWin) {
                    if(firstSymbolInColumn.equals("X")) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }

            boolean majorDiagonalWin = true;
            String firstSymbolInDiagonal = board[0][0];
            for(int i = 0; i < board.length; i++) {
                if(!board[i][i].equals(firstSymbolInDiagonal)) {
                    majorDiagonalWin = false;
                    break;
                }
            }
            if(majorDiagonalWin) {
                if(firstSymbolInDiagonal.equals("X")) {
                    return 1;
                } else {
                    return -1;
                }
            }

            boolean minorDiagonalWin = false;
            firstSymbolInDiagonal = board[0][2];
            for(int i = 0; i < board.length; i++) {
                if(!board[i][2 - i].equals(firstSymbolInDiagonal)) {
                    minorDiagonalWin = false;
                    break;
                }
            }
            if(majorDiagonalWin) {
                if(firstSymbolInDiagonal.equals("X")) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return 0;
        }
    }
}
