public class countofnds {
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
    }

    // count of nodes
    public static int countofNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftnodes = countofNodes(root.left);
        int rightnodes = countofNodes(root.right);
        return leftnodes + rightnodes + 1;

    }

    // sum of nodes first sum of left and then sum of right subtree
    public static int sumofNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftnodes = sumofNodes(root.left);
        int rightnodes = sumofNodes(root.right);
        return leftnodes + rightnodes + root.data;

    }

    // height of nodes first find left subtree height and right then using Math.max
    // to calculate maximum of whose tree has maximum number
    public static int heightofNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftnodes = heightofNodes(root.left);
        int rightnodes = heightofNodes(root.right);
        int myheight = Math.max(leftnodes, rightnodes) + 1;
        return myheight;

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(countofNodes(root));
        System.out.println(sumofNodes(root));
        System.out.println(heightofNodes(root));

    }
}
