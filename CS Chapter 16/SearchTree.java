// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.  from Reges and Stepp, Building Java Programs
//
// modified by W.P. Iverson, to not allow duplicates added
// added toString()
// Bellevue College, January 2021

public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = null;
    }

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) > 0) {
            root.left = add(root.left, value);
        } else if (root.data.compareTo(value) < 0) {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else {
            int compare = value.compareTo(root.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(root.left, value);
            } else { // compare > 0
                return contains(root.right, value);
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }

    // toString() added by W.P. Iverson for simple console testing
    // since String is immutable, I've used StringBuilder
    public String toString() {
        StringBuilder s = new StringBuilder();
        toString(overallRoot, 0, s);
        return s.toString();
    }

    // similar reverse in order traversal of tree as print sideways
    private void toString(SearchTreeNode<E> root, int level, StringBuilder s) {
        if (root != null) {
            toString(root.right, level + 1, s);
            String temp = new String(); // different for each node
            for (int i = 0; i < level; i++) {
                temp += " ";
            }
            s.append(temp + root.data + "\n"); // uses same String in recursions
            toString(root.left, level + 1, s);
        }
    }

    // A. Exercise #7 isFull();
    public boolean isFull() {
        return isFull(overallRoot);
    }

    private boolean isFull(SearchTreeNode<E> root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right != null) {
            return isFull(root.left) && isFull(root.right);
        } else {
            return false;
        }
    }

    // B. Exercise #9 equals2(t2);
    public boolean equals2(SearchTree<E> t2) {
        return equals2(overallRoot, t2.overallRoot);
    }

    private boolean equals2(SearchTreeNode<E> n1, SearchTreeNode<E> n2) {
        if (n1 == null || n2 == null) {
            return n1 == n2;
        } else if (n1.data.equals(n2.data)) {
            return equals2(n1.left, n2.left) && equals2(n1.right, n2.right);
        } else {
            return false;
        }
    }

    // C. Exercise #12 removeLeaves();
    public void removeLeaves() {
        overallRoot = removeLeaves(overallRoot);
    }

    private SearchTreeNode<E> removeLeaves(SearchTreeNode<E> root) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            return null;
        } else {
            root.left = removeLeaves(root.left);
            root.right = removeLeaves(root.right);
            return root;
        }
    }

    // D. remove(data);
    public void remove(E value) {
        overallRoot = remove(overallRoot, value);
    }

    private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return null;
        } else if (root.data.compareTo(value) > 0) {
            root.left = remove(root.left, value);
        } else if (root.data.compareTo(value) < 0) {
            root.right = remove(root.right, value);
        } else { // root.data == value, remove this node
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else { // both children are present
                root.data = getMax(root.left);
                root.left = remove(root.left, root.data);
            }
        }
        return root;
    }

    private E getMax(SearchTreeNode<E> root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    // a private inner Class for the search tree nodes
    // there is no use for such nodes outside of the SearchTree Class
    // so a private inner Class is appropriate in this case...
    private static class SearchTreeNode<E> {
        public E data; // data stored in this node
        public SearchTreeNode<E> left; // left subtree
        public SearchTreeNode<E> right; // right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                               SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
