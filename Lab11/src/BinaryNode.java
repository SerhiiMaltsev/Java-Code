import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryNode {
	
	private int data;
	private BinaryNode leftChild;
	private BinaryNode rightChild;
	private int numOfL;
	
	public BinaryNode(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
		this.numOfL = 0;
	}
	
	//getters and setters
	public int getData() {
		return this.data;
	}
	
	public BinaryNode getLeftChild() {
		return this.leftChild;
	}
	
	public BinaryNode getRightChild() {
		return this.rightChild;
	}
	
	public void setLeftChild(BinaryNode newLeftChild) {
		this.leftChild = newLeftChild;
	}
	
	public void setRightChild(BinaryNode newRightChild) {
		this.rightChild = newRightChild;
	}
	
	/**
	 * Gets the number of leaves in the tree with "this" as root
	 * @return the number of leaves in the tree
	 */
	public int numLeaves() {
		return numLeavesHelper(this.leftChild) + numLeavesHelper(this.rightChild);
	}
	
	public int numLeavesHelper(BinaryNode x) {
		if (x == null) {
			return 0;
		} if (x.leftChild == null && x.rightChild == null) {
			return 1;
		} else {
			return numLeavesHelper(x.leftChild) + numLeavesHelper(x.rightChild);
		}
	}
	
//	/**
//	 * Gets the breadth-first search traversal of the tree with "this" as root
//	 * Each node's data should have the format (data) Ex: (5) and (10)
//	 * @return the bfs traversal
//	 */
	public static String breadthFirstSearch(BinaryNode root) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		ArrayList<Integer> x = new ArrayList<Integer>();
		//put root on queue to start it off
		queue.add(root);
		while (queue.isEmpty() == false) {
			if(queue.peek().leftChild != null) {
				queue.add(queue.peek().leftChild);
			}
			if (queue.peek().rightChild != null) {
				queue.add(queue.peek().rightChild);
			}
			x.add(queue.peek().data);
			queue.remove();
			
		}
		String ans = "";
		for (int i: x) {
			ans = ans + "(" + i + ")"; 
		}
		
		return ans;
	}
}
