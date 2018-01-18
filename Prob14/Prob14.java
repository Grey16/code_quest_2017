import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Prob14 {
    public static void main(String[] args) {
        try {
            File f = new File("Prob14.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            int n = Integer.parseInt(br.readLine());
            HashMap<String, Node> map = new HashMap<String, Node>();
            Node top = new Node("None");
            map.put("None", top);

            for(int i = 0; i < n; i++) {
                String[] currInput = br.readLine().split(",");
                String itemName = currInput[0];
                String parentName = currInput[1];
                Node parent = map.get(parentName);

                Node item = new Node(itemName);
                map.put(itemName, item);

                parent.add(item);
            }
            top.print(-1);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static class Node implements Comparable<Node> {
        String name;
        ArrayList<Node> children;

        // default constructor that takes the name or key as a parameter
        public Node(String inputName) {
            name = inputName;
            children = new ArrayList<Node>();
        }

        // adds a child Node to the ArrayList of the parent Node
        public void add(Node child) {
            children.add(child);
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Node otherNode) {
            return name.compareTo(otherNode.getName());
        }

        public void print(int depth) {
            if(depth >= 0) {
                for(int i = 0; i < depth; i++) {
                    System.out.print("-");
                }
                System.out.println(name);
            }

            if(children.size() > 0) {
                Node[] childrenArray = new Node[children.size()];
                childrenArray = children.toArray(childrenArray);

                Arrays.sort(childrenArray);

                for(Node child: childrenArray) {
                    child.print(depth + 1);
                }
            }
        }
    }
}
