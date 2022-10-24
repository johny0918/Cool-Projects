/* Your Name: Jonathan Santos 
 * Your Course Number (CS2013)
 * Your Section Numbers: 01
 * Description: The purpose of this class is to create BST nodes
 */

package hw07;

//BST Node Class
public class BSTNode <E extends Comparable<E>> {
	//pointer variables
	protected BSTNode<E> parent;
	protected BSTNode<E> left;
	protected BSTNode<E> right;
	protected E data;
	
	//data constructor
	BSTNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	//getter
	public E getData() {
		return data;
	}

	//setter
	public void setData(E data) {
		this.data = data;
	}
}
