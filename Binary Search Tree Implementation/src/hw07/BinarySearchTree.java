/* Your Name: Jonathan Santos 
 * Your Course Number (CS2013)
 * Your Section Numbers: 01
 * Description: The purpose of this class is to create and implement the multiple Binary Search Tree Algorithms
 */

package hw07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Binary Search Tree Class
public class BinarySearchTree <E extends Comparable<E>>{
	private BSTNode<E> root;

	//default constructor
	BinarySearchTree() {
		this.root = null;
	}

	//binary search tree constructor with given elements
	BinarySearchTree(E...values){
		this.root = null;
		for (int i = 0; i < values.length; i++) {
			insert(values[i]);
		}
	}

	//insert method
	public void insert(E value) {
		//local node 
		BSTNode<E> child = new BSTNode(value);

		//checks if BST is empty
		if (isEmpty()) {
			root = child;
		} else {
			//try/catch method
			try {
				//sends value from insertion point to child pointer
				child.parent = insertionPoint(value);
				//checks if value is less than child pointer
				if (value.compareTo(child.parent.data) < 0) {
					child.parent.left = child;
					//checks if value is greater than child pointer
				} else if (value.compareTo(child.parent.data) > 0) {
					child.parent.right = child;
				}
				//custom exception
			} catch (DuplicateItemException ex){
				System.err.println("Duplicate Item Exception: No Duplicate Items Allowed!");
			}
		}
	}

	//insertion point method
	private BSTNode insertionPoint(E key) throws DuplicateItemException{
		//local generic nodes
		BSTNode<E> current = root;
		BSTNode<E> parent = null;

		//while loop
		while (current != null) {
			//checks if both key and current pointer data are equal
			if (key == current.data) {
				throw new DuplicateItemException("No Duplicate Items Allowed!");
				//checks if given key is less than current pointer data
			} else if (key.compareTo(current.data) < 0) {
				parent = current;
				current = current.left;
				//checks if given key is greater than current pointer data
			} else if (key.compareTo(current.data) > 0) {
				parent = current;
				current = current.right;
			}
		}

		//return statement
		return parent;
	}

	//delete method
	public void delete(E value) {
		//local node
		BSTNode<E> newNode = nodeToDelete(value);
		del(newNode);
	}

	//method to find node and return it back to delete method
	private BSTNode nodeToDelete(E key) {
		//local node
		BSTNode<E> current = root;

		//while loop
		while (current != null) {
			//checks if given value is equal to current data in the BST and returns current node
			if (key == current.data) {
				return current;
				//checks if key is greater or less than current data and changes pointer variable to the left or right
			} else if (key.compareTo(current.data) < 0) {
				current = current.left;
			} else if (key.compareTo(current.data) > 0) {
				current = current.right;
			}
		}
		//return null
		return null;
	}

	//deletes specific node in BST
	private void del(BSTNode<E> node) {
		//local nodes
		BSTNode<E> child = null;
		BSTNode<E> max = null;

		//checks if node is null and ends method
		if (node == null) {
			System.out.println("Error. Given Node is not located in the Binary Search Tree.");
		//checks if node is a leaf
		} else if (isLeaf(node)) {
			//checks if node is a left child
			if (isLeftChild(node)) {
				node.parent.left = null;
				//checks if node is a right child
			} else if (isRightChild(node)) {
				node.parent.right = null;
			}
			//checks if number of child is 1
		} else if (numChildren(node) == 1) {
			//checks if node's left child is null and assigns data into child 
			if (node.left == null) {
				child = node.right;
				//checks if node's right child is null and assigns data into null
			} else if (node.right == null) {
				child = node.left;
			}
			//checks if node is a left child
			if (isLeftChild(node)) {
				node.parent.left = child;
				//checks if node is a right child
			} else if (isRightChild(node)) {
				node.parent.right = child;
			}
			//checks if number of children is 2
		} else if (numChildren(node) == 2) {
			//finds max of left subtree node in stores it into max 
			max = maxLeftSubtree(node);
			node.setData(max.getData());
			//recursive statement
			del(max);
		}
	}

	//finds and returns max in a given 2 children node left subtree
	private BSTNode maxLeftSubtree(BSTNode<E> node) {
		//local node
		BSTNode<E> max = node;

		//checks if node's right descendant to assign node's left child to max 
		if (node.left.right == null) {
			max = node.left;
		} else {
			node = node.left;
			//while loop that assigns maximum value into max node
			while (node != null) {
				max = node.right;
				node = node.right;
			}
		}
		//return statement
		return max;
	}

	//find method
	public boolean find(E value) {
		//local generic nodes
		BSTNode<E> current = root;

		//while loop
		while (current != null) {
			//checks if given value is equal to current data in the BST and returns true
			if (value == current.data) {
				return true;
				//checks if key is greater or less than current data and changes pointer variable to the left or right
			} else if (value.compareTo(current.data) < 0) {
				current = current.left;
			} else if (value.compareTo(current.data) > 0) {
				current = current.right;
			}
		}
		//return false
		return false;
	}

	//is empty method
	public boolean isEmpty() {
		return root == null;
	}

	//preorder method
	public ArrayList<E> preorder() {
		//local temp arraylist
		ArrayList<E> temp = preOrder(root);

		//return statement
		return temp;
	}

	//search traversal
	private ArrayList<E> preOrder(BSTNode<E> node) {
		//local arraylist and node
		ArrayList<E> temp = new ArrayList();
		BSTNode<E> current = node;

		//base case
		if (current == null) {
			return temp;
		}

		//adds current data into arraylist
		temp.add(current.data);
		//checks if current left pointer is null
		if (current.left != null) {
			temp.addAll(preOrder(current.left));
		}
		//checks if current right pointer is null
		if (current.right != null) {
			temp.addAll(preOrder(current.right));
		}
		//return statement
		return temp;
	}

	//inorder method
	public ArrayList<E> inorder() {
		//local array arraylist
		ArrayList<E> temp = inOrder(root);

		//return statement
		return temp;
	}

	//search traversal
	private ArrayList<E> inOrder(BSTNode<E> node) {
		//local node and arraylist
		ArrayList<E> temp = new ArrayList();
		BSTNode<E> current = node;

		//base case
		if (current == null) {
			return temp;
		}

		//checks if current left pointer is null
		if (current.left != null) {
			temp.addAll(inOrder(current.left));
		}
		//adds current data elements into temp arraylist
		temp.add(current.data);
		//checks if current right pointer is null
		if (current.right != null) {
			temp.addAll(inOrder(current.right));
		}
		//return statement 
		return temp;
	}

	//postorder method
	public ArrayList<E> postorder() {
		//local arraylist
		ArrayList<E> temp = postOrder(root);

		//return statement 
		return temp;
	}

	//search traversal
	private ArrayList<E> postOrder(BSTNode<E> node) {
		//local node and arraylist
		ArrayList<E> temp = new ArrayList();
		BSTNode<E> current = node;

		//base case
		if (current == null) {
			return temp;
		}

		//checks if current left pointer is null
		if (current.left != null) {
			temp.addAll(postOrder(current.left));
		}
		//checks if current right pointer is null
		if(current.right != null) {
			temp.addAll(postOrder(current.right));
		}
		//adds current data element into temp arraylist 
		temp.add(current.data);
		//return statement 
		return temp;
	}

	//breadthfirst method
	public ArrayList<E> breadthfirst() {
		//local arraylist and queue
		ArrayList<E> temp = new ArrayList();
		Queue<BSTNode> queue = new LinkedList();
		//adding root into queue
		queue.add(root);

		//loops until loop is not empty
		while (!queue.isEmpty()) {
			//creates new node
			BSTNode<E> node = queue.remove();
			//adds node data into temp arraylist
			temp.add(node.data);
			//checks if left node pointer is null
			if (node.left != null) {
				queue.add(node.left);
			}
			//checks if right node pointer is null
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		//return statement 
		return temp;
	}

	//is leaf method
	private boolean isLeaf(BSTNode node) {
		//checks if node's left or right child is null and returns it true, otherwise returns false
		if (node.left == null && node.right == null) {
			return true;
		} else {
			return false;
		}
	}

	//if left child method
	private boolean isLeftChild(BSTNode<E> node) {
		return node.parent.left.data.equals(node.data);
	}

	//is right child method
	private boolean isRightChild(BSTNode<E> node) {
		return node.parent.right.data.equals(node.data);
	}

	//number of children method
	private int numChildren(BSTNode<E> node) {
		//local variable
		int count = 0;

		//increases count if node's left or right child is not null
		if (node.left != null) {
			count++;
		} 
		if (node.right != null) {
			count++;
		}
		//return statement
		return count;
	}

	//to String method
	public String toString() {
		String str = "";

		if (this.root.right != null) {
			str += printTree(this.root.right, true, "");
		}

		str += printNodeValue(this.root);

		if (this.root.left != null) {
			str += printTree(this.root.left, false, "");
		}

		return str;
	}

	private String printTree(BSTNode<E> node, boolean isRight, String indent) {
		String str = "";

		if (node.right != null) {
			str += printTree(node.right, true, indent + (isRight ? "        " : " |      "));
		}

		str += indent;

		if (isRight) {
			str += " /";
		} else {
			str += " \\";
		}

		str += "---- ";
		str += printNodeValue(node);
		if (node.left != null) {
			str += printTree(node.left, false, indent + (isRight ? " |      " : "        "));
		}

		return str;
	}

	private String printNodeValue(BSTNode<E> node) {
		String str = "";

		if (node == null) {
			str += "<null>";
		} else {
			str += node.getData();
		}
		str += "\n";
		return str;
	}
}
