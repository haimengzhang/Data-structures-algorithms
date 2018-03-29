import java.util.*;

/**
 * A BinaryTree is a tree with nodes that have up to two children.
 */
public class BinaryTree {


    /**
     * root is the root of this BinaryTree
     */
    private TreeNode root;
//    public static BinaryTree fibTree(int n) {
//        BinaryTree result = new BinaryTree();
//        return new BinaryTree(new TreeNode((Integer) n).fibTreeHelper(n));
//
//    }
    public static BinaryTree exprTree(String s) {
        BinaryTree result = new BinaryTree();
        result.root = result.exprTreeHelper(s);
        return result;
    }
    // Return the tree corresponding to the given arithmetic expression.
// The expression is legal, fully parenthesized, contains no blanks,
// and involves only the operations + and *.
    private TreeNode exprTreeHelper(String expr) {
        if (expr.charAt(0) != '(') {
            // you fill this in
            return new TreeNode(expr);
        } else {
            // expr is a parenthesized expression.
            // Strip off the beginning and ending parentheses,
            // find the main operator (an occurrence of + or * not nested
            // in parentheses, and construct the two subtrees.
            int nesting = 0;
            int opPos = 0;
            for (int k = 1; k < expr.length() - 1; k++) {
                // you supply the missing code
                if (expr.charAt(k) == '(') {
                    nesting ++;
                }
                if (expr.charAt(k) == ')' ) {
                    nesting --;
                }
                if (nesting == 0 && (expr.charAt(k)== '*' || expr.charAt(k)== '+')) {
                    opPos=k;
                    break;
                }
            }
            String opnd1 = expr.substring(1, opPos);
            String opnd2 = expr.substring(opPos + 1, expr.length() - 1);
            String op = expr.substring(opPos, opPos + 1);

            System.out.println("expression = " + expr);
            System.out.println("operand 1  = " + opnd1);
            System.out.println("operator   = " + op);
            System.out.println("operand 2  = " + opnd2);
            System.out.println();

            TreeNode left = exprTreeHelper(opnd1);
            TreeNode right = exprTreeHelper(opnd2);
            return new TreeNode(op,left, right); // you fill this in
        }
    }

    public void optimize() {
        if (root !=null ) {
            root.optimize();
        }



    }
    public boolean validateInt(String s) {
        for (int k = 1; k < s.length(); k++) {
            if (Character.isDigit(s.charAt(k))) {
                return true;
            }
        }return false;

    }




    /**
     * The BinaryTree constructor
     */
    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode t) {
        root = t;
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * Print the values in the tree in preorder: root value first, then values
     * in the left subtree (in preorder), then values in the right subtree
     * (in preorder).
     */
    public void printPreorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printPreorder();
            System.out.println();
        }
    }



    /**
     * Print the values in the tree in inorder: values in the left subtree
     * first (in inorder), then the root value, then values in the first
     * subtree (in inorder).
     */
    public void printInorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printInorder();
            System.out.println();
        }
    }
    public void print() {
        if (root != null) {
            root.print(0);
        }
    }


    public boolean check() {
        alreadySeen = new ArrayList();
        try {
            isOK(root);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    // Contains nodes already seen in the traversal.
    private ArrayList alreadySeen;
    private void isOK(TreeNode t) throws IllegalStateException {
        if (alreadySeen.contains(t)) {
            throw new IllegalStateException();
        }
        alreadySeen.add(t);
        if (t.left!=null) {
            isOK(t.left);
        }
        if (t.right !=null ) {
            isOK(t.right);
        }
    }

    /**
     * Fills this BinaryTree with values a, b, and c.
     * DO NOT MODIFY THIS METHOD.
     */
    public void fillSampleTree1() {
        root = new TreeNode("a", new TreeNode("b"), new TreeNode("c"));
    }

    /**
     * Fills this BinaryTree with values a, b, and c, d, e, f.
     * DO NOT MODIFY THIS METHOD.
     */
    public void fillSampleTree2() {
        root = new TreeNode("a", new TreeNode("b", new TreeNode("d",
            new TreeNode("e"), new TreeNode("f")), null), new TreeNode("c"));
    }

    /**
     * Fills this BinaryTree with the values a, b, c, d, e, f in the way that the spec pictures.
     */
    public void fillSampleTree3() {
        //YOUR CODE HERE.
        root = new TreeNode("a", new TreeNode("b" ), new TreeNode("c", new TreeNode("d", new TreeNode("e"), new TreeNode("f")), null));
    }

    /**                                                                          
     * Fills this BinaryTree with the same leaf TreeNode.                        
     * DO NOT MODIFY THIS METHOD.                                                
     */ 
    public void fillSampleTree4() {
        TreeNode leafNode = new TreeNode("c");                                   
        root = new TreeNode("a", new TreeNode("b", leafNode, leafNode), new TreeNode("d", leafNode, leafNode));
    }
    /**
     * Like the Amoeba class, returns the height of the deepest node.
     **/
    public int height() {
        //YOUR CODE HERE
<<<<<<< HEAD
        if (root != null) {
            return root.heightHelper();
        }return 0;
=======

        return helper1(root);
    }

    public int helper1(TreeNode t) {
        if (t == null)
            return 0;
        if (t.left == null && t.right == null)
            return 1;
        return 1 + Math.max(helper1(t.left), helper1(t.right));

>>>>>>> 297c9d218d260f71f82e1c894502799d38f2b1aa
    }

    public boolean isCompletelyBalanced() {
        //YOUR CODE HERE
<<<<<<< HEAD
        if (root != null) {
            root.isBalancedHelper();
        }
        return true;
=======
        if (root == null)
            return true;
        return helper1(root.getLeft()) == helper1(root.getRight());

>>>>>>> 297c9d218d260f71f82e1c894502799d38f2b1aa
    }


    /**
     * Creates two BinaryTrees and prints them out in inorder
     */
    public static void main(String[] args) {
        BinaryTree t;
        t = new BinaryTree();
        print(t, "the empty tree");
        t.fillSampleTree1();
        print(t, "sample tree 1");
        t.fillSampleTree2();
        print(t, "sample tree 2");
    }

    /**
     * Prints out the contents of a BinaryTree with a description in both
     * preorder and inorder
     * @param t           the BinaryTree to print out
     * @param description a String describing the BinaryTree t
     */
    private static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println();
    }

    /**
     * A TreeNode is a Node this BinaryTree
     * Note: this class is public in this lab for testing purposes.
     * However, in professional settings as well as the rest of
     * your labs and projects, we recommend that you keep your
     * classes private.
     */
    public static class TreeNode {

        /**
         * item is the item that is contained in this TreeNode
         * left is the left child of this TreeNode
         * right is the right child of this TreeNode
         */
        public Object item;
        public TreeNode left;
        public TreeNode right;

        /**
         * A TreeNode constructor that creates a node with obj as its item
         * @param  obj the item to be contained in this TreeNode
         */
        TreeNode(Object obj) {
            item = obj;
            left = null;
            right = null;
        }

        /**
         * A TreeNode constructor that creates a node with obj as its item and
         * left and right as its children
         * @param  obj   the item to be contained in this TreeNode
         * @param  left  the left child of this TreeNode
         * @param  right the right child of this TreeNode
         */
        TreeNode(Object obj, TreeNode left, TreeNode right) {
            item = obj;
            this.left = left;
            this.right = right;
        }

        public Object getItem() {
            return item;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        /**
         * Prints this TreeNode and the subtree rooted at it in preorder
         */

        public static Integer decode(String expr) {
            try {
                return Integer.decode(expr);
            } catch (NumberFormatException e) {
                return null;
            }
        }
            // only got here if we didn't return false

        public void optimize() {
            if (left != null) left.optimize();
            if (right !=null) right.optimize();

        }
        private void printPreorder() {
            System.out.print(item + " ");
            if (left != null) {
                left.printPreorder();
            }
            if (right != null) {
                right.printPreorder();
            }
            switch ((String)item) {
                case "+" : {
                    Integer leftnum = decode((String) (left.item));
                    Integer rightnum = decode((String) (left.item));
                    if (leftnum != null && rightnum != null) {
                        item = new Integer(leftnum + rightnum).toString();
                    }
                } case "*": {
                    Integer leftValue = decode((String) left.item);
                    Integer rightValue = decode((String) right.item);
                    if (leftValue != null && rightValue != null) {

                        item = new Integer(leftValue * rightValue).toString();
                    }
                }
            }

        }


        /**
         * Prints this TreeNode and the subtree rooted at it in inorder
         */
        private void printInorder() {
            if (left != null) {
                left.printInorder();
            }
            System.out.print(item + " ");
            if (right != null) {
                right.printInorder();
            }
        }


        //Add more recursive methods here!
        public int heightHelper() {
            if (right == null && left == null) {
                return 1;
            }else
                return 1+ Math.max(left.heightHelper(), right.heightHelper());
        }
        public boolean isBalancedHelper() {
            if (left==null && right == null) {
                return true;
            }
            if (left.heightHelper()== right.heightHelper()) {
                //height has to be same first, before I say each node is balanced.
                return left.isBalancedHelper() && right.isBalancedHelper();
            }else return false;
        }
        //Copy into TreeNode class
        private static final String indent1 = "    ";

        private void print(int indent) {
            if (right != null)
                right.print(indent+1);
            for (int k = 0; k <= indent; k++) {
                System.out.print(indent1);
            }System.out.println(item + " ");
            // TODO your code here
            if (left != null) {
                left.print(indent+1);
            }
        }

        private static void println(Object obj, int indent) {
            for (int k=0; k<indent; k++) {
                System.out.print(indent1);
            }
            System.out.println(obj);
        }

        public TreeNode fibTreeHelper(int n){
            if (n == 0){
                return new TreeNode(new Integer(0));
            }
            if (n == 1){
                return new TreeNode(new Integer(1));
            }TreeNode right = fibTreeHelper(n - 2);
            TreeNode left = fibTreeHelper(n - 1);
            return new TreeNode((Integer)left.item + (Integer)right.item, left, right);
        }


    }


}
