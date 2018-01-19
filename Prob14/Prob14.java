import java.io.*;
import java.util.*;

public class Prob14 {
    public static void main(String[] args) {
        try {
            // set up input handling
            File f = new File("Prob14.in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            // set up hashmap
            HashMap<String, Node> map = new HashMap<String, Node>();

            // set up top level
            Node top = new Node("None");
            map.put("None", top);

            int n = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                String[] currInput = br.readLine().split(",");
                String itemName = currInput[0];
                String parentName = currInput[1];

                // create a new Node for the item
                Node item = new Node(itemName);
                // put the item on the hashmap with the item's name as its key
                map.put(itemName, item);

                // obtain the parent
                Node parent = map.get(parentName);
                // add the child Node to the parent's children
                parent.add(item);
            }

            // print hashmap
            top.print(-1);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static class Node implements Comparable<Node> {
        String name;
        ArrayList<Node> children;

        // constructor
        public Node(String inputName) {
            name = inputName;
            children = new ArrayList<Node>();
        }

        // adds a child Node to the parent's children
        public void add(Node childNode) {
            children.add(childNode);
        }

        // returns the Node's name
        private String getName() {
            return name;
        }

        // compares the Node's names
        @Override
        public int compareTo(Node otherNode) {
            return name.compareTo(otherNode.getName());
        }

        public void print(int depth) {
            // prints itself if not at the top level
            if(depth >= 0) {
                for(int i = 0; i < depth; i++) {
                    System.out.print("-");
                }
                System.out.println(name);
            }

            // check if node has children
            if(children.size() > 0) {
                // create an array the size of the children ArrayList
                Node[] childArray = new Node[children.size()];
                childArray = children.toArray(childArray);

                // sort childArray alphabetically
                Arrays.sort(childArray);

                // recursively print children
                for(Node child : childArray) {
                    child.print(depth + 1);
                }
            }
        }
    }
}
