import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class JUnit {
	
	protected static void createTree2(BinaryTree<String> tree)
	{ 
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

		tree.setTree("A", bTree, cTree);
	}
	
	protected static void createTree3(BinaryTree<String> tree)
	{ 
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

		tree.setTree("A", bTree, cTree);
	}
	
	BinaryTree<String> aTree = new BinaryTree<>();
	BinaryTree<String> anotherTree = new BinaryTree<>();
	
	
	@Test //Test 1
	public void testPostorderTraverse()
	{
		createTree2(aTree);
		aTree.postorderTraverse();
		System.out.println();
	}
	
	
	@Test //Test 2
	public void testPostorderTraverse_callBinaryNodeMethod()
	{
		createTree2(aTree);
		aTree.postorderTraverse_callBinaryNodeMethod();
		System.out.println();
	}
	
	
	@Test //Test 3
	public void getHeight_callBinaryNodeMethodTest()
	{
		createTree2(aTree);
		assertEquals(new Integer(4), aTree.getHeight());
	}
	
	@Test //Test 4
	public void getHeight_binaryNodeMethodTest()
	{
		createTree2(aTree);
		assertEquals(new Integer(2), aTree.getHeight_callBinaryNodeMethod());
	}
	
	@Test //Test 5
	private void getNumberOfNodesTest()
	{
		createTree2(aTree);
		assertEquals(new Integer(7), aTree.getNumberOfNodes());
	
	}
    
    @Test //Test 6
    public void testCreateTree2()
    {
    	
    	createTree2(aTree);
    	createTree3(anotherTree);
    	
    	boolean [] aTree = null;
    	boolean [] anotherTree = null;
    	
    	assertEquals(anotherTree, aTree);
    }
	
}
