package TreePackage;
import java.util.Iterator;
import java.util.NoSuchElementException;
import StackAndQueuePackage.*; // Needed by tree iterators

/**
   A class that implements the ADT binary tree.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class BinaryTree<T> implements BinaryTreeInterface<T>
{
   private BinaryNode<T> root;

   public BinaryTree()
   {
      root = null;
   } // end default constructor

   public BinaryTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // end constructor

   public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      initializeTree(rootData, leftTree, rightTree);
   } // end constructor

    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree)
   {
      initializeTree(rootData, (BinaryTree<T>)leftTree,
                               (BinaryTree<T>)rightTree);
   } // end setTree

	private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
{
   root = new BinaryNode<>(rootData);

   if ((leftTree != null) && !leftTree.isEmpty())
      root.setLeftChild(leftTree.root);

   if ((rightTree != null) && !rightTree.isEmpty())
   {
      if (rightTree != leftTree)
         root.setRightChild(rightTree.root);
      else
         root.setRightChild(rightTree.root.copy());
   } // end if

   if ((leftTree != null) && (leftTree != this))
      leftTree.clear();

   if ((rightTree != null) && (rightTree != this))
      rightTree.clear();
} // end initializeTree

public void postorderTraverse()
{
   postorderTraverse(root);
}

private void postorderTraverse(BinaryNode<T> node)
{
   if(node != null)
   {
      postorderTraverse(node.getLeftChild());
      postorderTraverse(node.getRightChild());
      System.out.println(node.getData());
   }
}

/* Implementations of setRootData, getRootData, getHeight, getNumberOfNodes,
   isEmpty, clear, and the methods specified in TreeIteratorInterface are here.
   . . . */

} // end BinaryTree
