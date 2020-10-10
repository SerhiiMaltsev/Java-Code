import java.util.ArrayList;

/**
 * Binary Search Tree Class
 * 
 * The head class for a binary search tree implementation.
 * 
 * @author YOURID
 * @param <Comparable> Type of data to store in the binary tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

	/**
	 * A reference pointer to the root of the tree
	 */
	private BinaryTreeNode<T> root;

	/**
	 * Default constructor
	 * 
	 * Creates a binary tree object with null root note (empty tree)
	 */
	public BinarySearchTree() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * Creates a binary tree object with the given node as root
	 * 
	 * @param newRoot The root of the tree
	 */
	public BinarySearchTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}
	
	/**
	 * Get the root of the tree
	 * 
	 * @return The root of the tree
	 */
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Set the root of the tree
	 * 
	 * @param root  The new root of this tree
	 */
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}
	
	
	/**
	 * Returns the size of the tree (that is, the 
	 * number of nodes in the tree). 
	 *
	 */
	public int size() {
		return sizeHelper(this.root);
	}
	
	public int sizeHelper (BinaryTreeNode x) {
		if (x == null) {
			return 0;
		} else {
			return (1 + sizeHelper(x.getLeft()) + sizeHelper(x.getRight()));
		}
	}
	
	
	
	/**
	 * Returns the height of the tree. 
	 *
	 */
	public int height() {
		return heightHelper(this.root);
	}
	
	public int heightHelper (BinaryTreeNode x) {
		if (x == null) {
			return 0;
		} else {
			return maximum (heightHelper(x.getLeft()), heightHelper(x.getRight())) + 1;
		}
	}
	
	public int maximum (int a, int b) {
		if (a>=b) {
			return a;
		} else {
			return b;
		}
	}
	
	
	
	/**
	 * Find if an element exists
	 * 
	 * Checks to see if the value val appears in the
	 * tree (recursively).  Returns true if it appears
	 * and false otherwise.
	 * 
	 * @param val The value to find
	 * @return True if the tree contains the value, false otherwise
	 */
	public boolean find(T val) {
		return findHelper(this.root, val);
	}
	
	public boolean findHelper(BinaryTreeNode x, T val) {
		if (x == null) {
			return false;
		} else if (x != null && x.getData().equals(val) == true) {
			return true;
		}else if (val instanceof String && x.getData().toString().equals(val)) {
			return true;
		} else {
			boolean k = findHelper(x.getLeft(), val);
			boolean y = findHelper(x.getRight(), val);
			if (k == true || y == true) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * Insert an element
	 * 
	 * Inserts val into the tree where it should appear, returning
	 * true on success and false otherwise
	 * 
	 * @param val The value to insert
	 * @return True on success, false otherwise
	 */
	public boolean insert(T val) {
		if (this.root == null) {
			setRoot(new BinaryTreeNode (val));
			return true;
		} else {
			return insertHelper(this.root, val);
		}
	}
	
	public boolean insertHelper(BinaryTreeNode x, T val) {
		if (x.getData().compareTo(val) == 0) {
			return false;
		} else if (x.getData().compareTo(val) > 0 && x.getLeft() == null) {
			x.setLeft(new BinaryTreeNode(val));
			return true;
		} else if (x.getData().compareTo(val) < 0 && !(x.getRight() instanceof BinaryTreeNode)) {
			x.setRight(new BinaryTreeNode(val));
			return true;
		} else if (x.getLeft() != null && x.getData().compareTo(val) > 0) {
			return insertHelper(x.getLeft(), val);
		} else  if (x.getRight() != null && x.getData().compareTo(val) < 0) {
			return insertHelper(x.getRight(), val);
		} else {
			return false;
		}
	}
	/**
	 * Return a string that represents the data held at each 
	 * node following the rules of an in-order traversal.
	 * 
	 * Covered in class Wednesday, April 22
	 */
	public String inOrder() {
		return inOrderHelper(this.root);
	}
	
	public String inOrderHelper(BinaryTreeNode x) {
		if (x.getLeft() == null && x.getRight() == null) {
			return "(" + x.getData().toString() + ")";
		} else if (x.getLeft() != null && x.getRight() == null) {
			return inOrderHelper(x.getLeft()) + "(" + x.getData().toString() + ")";
		} else if (x.getLeft() == null && x.getRight() != null){
			return "(" + x.getData().toString() + ")" + inOrderHelper(x.getRight());
		} else {
			return inOrderHelper(x.getLeft()) + "(" +x.getData().toString() + ")" + inOrderHelper(x.getRight());
		}

	}
	
	/**
	 * Return a string that represents the data held at each 
	 * node following the rules of a post-order traversal.
	 * 
	 * Covered in class Wednesday, April 22
	 */
	public String postOrder() {
		return postOrderHelper(this.root);
	}
	
	public String postOrderHelper(BinaryTreeNode x) {
		if (x.getLeft() == null && x.getRight() == null) {
			return "(" + x.getData().toString() + ")";
		} else if (x.getLeft() != null && x.getRight() == null) {
			return postOrderHelper(x.getLeft()) + "(" + x.getData().toString() + ")";
		} else if (x.getLeft() == null && x.getRight() != null){
			return postOrderHelper(x.getRight()) + "(" + x.getData().toString() + ")";
		} else {
			return postOrderHelper(x.getLeft()) + postOrderHelper(x.getRight()) + "(" +x.getData().toString() + ")" ;
		}

	}

	/**
	 * Build from a list
	 * 
	 * Build the tree from the given list, overwriting any tree data
	 * previously stored in this tree.  Should read from beginning to
	 * end of the list and repeatedly call insert() to build the tree
	 * 
	 * If the tree is not empty when this method is called, you should
	 * empty the tree before adding any elements in list.
	 *
	 * @param list The list from which to build the tree
	 * @return True if successfully built, false otherwise
	 */
	public boolean buildFromList(ArrayList<T> list) {
		if (list.isEmpty() == true) {
			return false;
		} else {
		BinaryTreeNode newRoot = new BinaryTreeNode(list.get(0));
	    setRoot(newRoot);
	    boolean repetition = false;
	    for (int i = 0; i<list.size(); i++) {
	    	for (int j = i+1; j<list.size(); j++) {
	    		if (list.get(i) == list.get(j)) {
	    			repetition = true;
	    		}
	    	}
	    }
	    if (repetition == true) {
	    	return false;
	    } else {
	    	for (int i = 1; i<list.size(); i++) {
	    		insert(list.get(i));
	    	}
	    	return true;
	    }
		}
	}
	
	   
    /**
     * toString method
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return inOrder();
    }
	
	/**
	 * Main method
	 * 
	 * For testing, etc
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		BinarySearchTree x = new BinarySearchTree(new BinaryTreeNode("123"));
		x.insert("234");
		x.insert("456");
		System.out.println(x.getRoot().getRight().getRight().getData());
	}
}
