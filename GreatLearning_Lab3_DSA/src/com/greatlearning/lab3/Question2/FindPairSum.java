package com.greatlearning.lab3.Question2;

import java.util.HashSet;
import java.util.Set;

class Node {
	int key;
	Node left, right;

	public Node(int key) {
		this.key = key;
		left = right = null;
	}
}

public class FindPairSum {
	Node root;

	public static void main(String[] args) {
		FindPairSum tree = new FindPairSum();

		tree.root = tree.insert(tree.root, 40);
		tree.insert(tree.root, 20);
		tree.insert(tree.root, 60);
		tree.insert(tree.root, 10);
		tree.insert(tree.root, 30);
		tree.insert(tree.root, 50);
		tree.insert(tree.root, 70);
		System.out.println("Inorder Traverse");
		tree.inOrderTraverse(tree.root);

		int sum = 130;
		tree.findPairWithGivenSum(tree.root, sum);
        tree.findPairWithGivenSum(tree.root, 67);
	}

	private void findPairWithGivenSum(Node node, int sum) {
		Set<Integer> set = new HashSet<>();
		if (!findPairUtil(root, sum, set))
			System.out.println("Sum = 67:" + " nodes are not found" + "\n");

	}

	private boolean findPairUtil(Node node, int sum, Set<Integer> set) {
		if (node == null) {
			return false;
		}
		if (findPairUtil(node.left, sum, set))
			return true;
		int diff = sum - node.key;
		if (set.contains(diff)) {
			System.out.println("Sum = 130:" + " Pair is(" + diff + "," + node.key + ")");
			return true;
		} else {
			set.add(node.key);
		}
		return findPairUtil(node.right, sum, set);
	}

	private void inOrderTraverse(Node node) {
		if (node == null)
			return;
		inOrderTraverse(node.left);
		System.out.println(node.key + " ");
		inOrderTraverse(node.right);
	}

	private Node insert(Node node, int key) {
		if (node == null) {
			node = new Node(key);
			return node;
		}
		if (key < node.key) {
			node.left = insert(node.left, key);
		} else if (key > node.key) {
			node.right = insert(node.right, key);
		}
		return node;
	}

}
