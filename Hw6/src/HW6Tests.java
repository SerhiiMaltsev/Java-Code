import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class HW6Tests {

	@Test
	public void testSize() {
		BinarySearchTree x = new BinarySearchTree();
		x.insert(7);
		x.insert(3);
		x.insert(2);
		x.insert(1);
		x.insert(5);
		x.insert(4);
		x.insert(6);
		x.insert(9);
		x.insert(8);
		x.insert(10);
		
		BinarySearchTree y = new BinarySearchTree();
		y.insert(7);
		y.insert(3);
		y.insert(2);
		
		assertEquals("Size of the first tree: ", 10, x.size());
		assertEquals("Size of the second tree: ", 3, y.size());
	}
	
	@Test
	public void testHeight() {
		BinarySearchTree x = new BinarySearchTree();
		x.insert(7);
		x.insert(3);
		x.insert(2);
		x.insert(1);
		x.insert(5);
		x.insert(4);
		x.insert(6);
		x.insert(9);
		x.insert(8);
		x.insert(10);
		
		BinarySearchTree y = new BinarySearchTree();
		y.insert(7);
		y.insert(3);
		y.insert(2);
		
		assertEquals("Size of the first tree: ", 4, x.height());
		assertEquals("Size of the second tree: ", 3, y.height());
	}
	
	@Test
	public void testFind() {
		BinarySearchTree x = new BinarySearchTree();
		x.insert(7);
		x.insert(3);
		x.insert(2);
		x.insert(1);
		x.insert(5);
		x.insert(4);
		x.insert(6);
		x.insert(9);
		x.insert(8);
		x.insert(10);
		
		BinarySearchTree y = new BinarySearchTree();
		y.insert(7);
		y.insert(3);
		y.insert(2);
		
		assertEquals("Size of the first tree: ", true, x.find(1));
		assertEquals("Size of the second tree: ", false, y.find(1));
	}
	
	@Test
	public void testInsert() {
		BinarySearchTree x = new BinarySearchTree();
		x.insert(7);
		x.insert(3);
		x.insert(2);
		x.insert(1);
		x.insert(5);
		x.insert(4);
		x.insert(6);
		x.insert(9);
		x.insert(8);
		x.insert(10);
		
		BinarySearchTree y = new BinarySearchTree();
		y.insert(7);
		y.insert(3);
		y.insert(2);
		
		assertEquals("Size of the first tree: ", false, x.insert(1));
		assertEquals("Size of the second tree: ", true, y.insert(1));
	}
	
	@Test
	public void testInOrder() {
		BinarySearchTree x = new BinarySearchTree();
		x.insert(7);
		x.insert(3);
		x.insert(2);
		x.insert(1);
		x.insert(5);
		x.insert(4);
		x.insert(6);
		x.insert(9);
		x.insert(8);
		x.insert(10);
		
		BinarySearchTree y = new BinarySearchTree();
		y.insert(7);
		y.insert(3);
		y.insert(2);
		
		assertEquals("Size of the first tree: ", "(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)", x.inOrder());
		assertEquals("Size of the second tree: ", "(2)(3)(7)", y.inOrder());
	}
	
	@Test
	public void testPostOrder() {
		BinarySearchTree x = new BinarySearchTree();
		x.insert(7);
		x.insert(3);
		x.insert(2);
		x.insert(1);
		x.insert(5);
		x.insert(4);
		x.insert(6);
		x.insert(9);
		x.insert(8);
		x.insert(10);
		
		BinarySearchTree y = new BinarySearchTree();
		y.insert(7);
		y.insert(3);
		y.insert(2);
		
		assertEquals("Size of the first tree: ", "(1)(2)(4)(6)(5)(3)(8)(10)(9)(7)", x.postOrder());
		assertEquals("Size of the second tree: ", "(2)(3)(7)", y.postOrder());
	}
	

	@Test
	public void testToString() {
		BinarySearchTree x = new BinarySearchTree();
		x.insert(7);
		x.insert(3);
		x.insert(2);
		x.insert(1);
		x.insert(5);
		x.insert(4);
		x.insert(6);
		x.insert(9);
		x.insert(8);
		x.insert(10);
		
		BinarySearchTree y = new BinarySearchTree();
		y.insert(7);
		y.insert(3);
		y.insert(2);
		
		assertEquals("Size of the first tree: ", "(1)(2)(3)(4)(5)(6)(7)(8)(9)(10)", x.toString());
		assertEquals("Size of the second tree: ", "(2)(3)(7)", y.toString());
	}
	
	@Test
	public void testHightNode() {
		BinarySearchTree x = new BinarySearchTree();
		x.insert(7);
		x.insert(3);
		x.insert(2);
		x.insert(1);
		x.insert(5);
		x.insert(4);
		x.insert(6);
		x.insert(9);
		x.insert(8);
		x.insert(10);
		
		BinarySearchTree y = new BinarySearchTree();
		y.insert(7);
		y.insert(3);
		y.insert(2);
		
		assertEquals("Size of the first tree: ", 3, x.getRoot().getLeft().height());
		assertEquals("Size of the second tree: ", 2, y.getRoot().getLeft().height());
	}
	
	@Test
	public void testBuildFromList() {
		BinarySearchTree x = new BinarySearchTree();
		ArrayList<Integer> xl = new ArrayList<Integer>();
		xl.add(1);
		xl.add(2);
		xl.add(3);
		x.buildFromList(xl);
		BinarySearchTree y = new BinarySearchTree();
		ArrayList<Integer> yl = new ArrayList<Integer>();
		yl.add(2);
		yl.add(3);
		yl.add(1);
		y.buildFromList(yl);
		
		assertEquals("Size of the first tree: ", "(1)(2)(3)", x.inOrder());
		assertEquals("Size of the second tree: ", "(1)(2)(3)", y.inOrder());
	}

}
