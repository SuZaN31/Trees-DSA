// levelorder tree  to printing by level of  tree with next line

import java.util.*;

public class lvlodr {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            // create a queue of linklist
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            // check if queue isnot empty then run it
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                // while remove currNode check currNode is null or not
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    }
                    // here is add null to follow for other data to be removed with next line
                    else {
                        q.add(null);
                    }
                }
                // print the currNode data

                else {
                    System.out.print(currNode.data + " ");
                    // check if currNode of left treee has not null then add to it
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    // same as above for right substreee
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static void main(String[] args) {
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(nodes);
            levelorder(root);

        }
    }
}
