package com.bridgelabz.binarysearchtree;

public class BinaryTree<K extends Comparable<K>> 
{
	
	private BinaryTreeNode<K> root;
	
	private BinaryTreeNode<K> addRecursively(BinaryTreeNode<K> current, K key)
	{
		
		if(current == null) {
			return new BinaryTreeNode<K>(key);
		}
		
		int compareResult = key.compareTo(current.key);
		
		if(compareResult == 0)
			return current;
		if(compareResult < 0)
			current.left = addRecursively(current.left, key);
		else
			current.right = addRecursively(current.right, key);
		
		return current;
		
	}
	
	public void add(K key) 
	{
		this.root = this.addRecursively(root, key);
	}
	
	private boolean searchTreeRecursively(BinaryTreeNode<K> current, K key) 
	{
		if (current == null) 
		{
			return false;
		}
		int compareResult = key.compareTo(current.key);
		if (compareResult == 0) 
		{
			return true;
		}
		return compareResult < 0 ? searchTreeRecursively(current.left, key) : searchTreeRecursively(current.right, key);
	}

	
	public boolean searchTree(K key) 
	{
		return searchTreeRecursively(root, key);
	}
	
	private int getSizeRecursively(BinaryTreeNode<K> current) 
	{
		return current == null? 0: 1 + this.getSizeRecursively(current.left)+this.getSizeRecursively(current.right);
	}
	
	public int getSize() 
	{
		return this.getSizeRecursively(root);
	}
	
	public void printBinaryTree() 
	{
		System.out.println("Binary Tree: " + root);
	}
	
	@Override
	public String toString() 
	{
		return "BinaryTree{" + root + '}';
	}
}