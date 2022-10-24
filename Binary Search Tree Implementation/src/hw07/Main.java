/* Your Name: Jonathan Santos 
 * Your Course Number (CS2013)
 * Your Section Numbers: 01
 * Description: The purpose of this class is to test all the BST algorithms
 */
package hw07;

import java.util.ArrayList;

//Main Class
public class Main {
	public static void main(String[] args) {
		//initialize variables
		BinarySearchTree<Integer> integer = new BinarySearchTree(7, 6, 4, 5, 2, 10, 9, 8, 72, 87, 98);
		BinarySearchTree<String> string = new BinarySearchTree("Boy", "Abby", "Calvin", "Andrew", "Salami", "Interjection");
		BinarySearchTree<Character> character = new BinarySearchTree('I', 'D', 'E', 'X', 'U' ,'G', 'L');

		//Initialized Binary Search Tree Testing
		System.out.println("-------------------Binary Search Tree of initialized Integers, Strings, and Characters --------------------");
		System.out.println("Integer Testing: ");
		System.out.println("Initialized Integer Variables: 7, 6, 4, 5, 2, 10, 9, 8, 72, 87, 98");
		System.out.println("Expected: ");		
		System.out.println();
		System.out.println("			/---- 98\r\n"
				+ "                 /---- 87\r\n"
				+ "         /---- 72\r\n"
				+ " /---- 10\r\n"
				+ " |       \\---- 9\r\n"
				+ " |               \\---- 8\r\n"
				+ "7\r\n"
				+ " \\---- 6\r\n"
				+ "         |       /---- 5\r\n"
				+ "         \\---- 4\r\n"
				+ "                 \\---- 2");
		System.out.println();
		System.out.println("Result:\n ");
		System.out.println(integer);
		System.out.println();

		System.out.println("String Testing: ");
		System.out.println("Initialized String Variables: Boy, Abby, Calvin, Andrew, Salami, Interjection");
		System.out.println("Expected: ");		
		System.out.println();
		System.out.println("         /---- Salami\r\n"
				+ "         |       \\---- Interjection\r\n"
				+ " /---- Calvin\r\n"
				+ "Boy\r\n"
				+ " |       /---- Andrew\r\n"
				+ " \\---- Abby");
		System.out.println();
		System.out.println("Result:\n ");
		System.out.println(string);
		System.out.println();

		System.out.println("Character Testing: ");
		System.out.println("Initialized Character Variable: I, D, E, X, U, G, L");
		System.out.println("Expected: "); 
		System.out.println();
		System.out.println("/---- X\r\n"
				+ " |       \\---- U\r\n"
				+ " |               \\---- L\r\n"
				+ "I\r\n"
				+ " |               /---- G\r\n"
				+ " |       /---- E\r\n"
				+ " \\---- D");
		System.out.println();
		System.out.println("Result:\n ");
		System.out.println(character);
		System.out.println();

		//Insert Testing
		System.out.println("-------------------Insert Function Testing--------------------");
		System.out.println("Integer Testing: ");
		System.out.println("Testing with Integer Variable: 19");
		System.out.println("Expected: ");		
		System.out.println();
		System.out.println("           		/---- 98\r\n"
				+ "                 /---- 87\r\n"
				+ "         /---- 72\r\n"
				+ "         |       \\---- 19\r\n"
				+ " /---- 10\r\n"
				+ " |       \\---- 9\r\n"
				+ " |               \\---- 8\r\n"
				+ "7\r\n"
				+ " \\---- 6\r\n"
				+ "         |       /---- 5\r\n"
				+ "         \\---- 4\r\n"
				+ "                 \\---- 2\r\n"
				+ "");
		System.out.println();
		System.out.println("Result:\n ");
		integer.insert(19);
		System.out.println(integer);
		System.out.println();

		System.out.println("String Testing: ");
		System.out.println("Testing with String Variable: Honda");
		System.out.println("Expected: ");
		System.out.println();
		System.out.println("         /---- Salami\r\n"
				+ "         |       \\---- Interjection\r\n"
				+ "         |               \\---- Honda\r\n"
				+ " /---- Calvin\r\n"
				+ "Boy\r\n"
				+ " |       /---- Andrew\r\n"
				+ " \\---- Abby");
		System.out.println();
		System.out.println("Result:\n ");
		string.insert("Honda");
		System.out.println(string);
		System.out.println();

		System.out.println("Character Testing: ");
		System.out.println("Testing with Character Variable: J");	
		System.out.println("Expected: ");
		System.out.println();
		System.out.println(" /---- X\r\n"
				+ " |       \\---- U\r\n"
				+ " |               \\---- L\r\n"
				+ " |                       \\---- J\r\n"
				+ "I\r\n"
				+ " |               /---- G\r\n"
				+ " |       /---- E\r\n"
				+ " \\---- D");
		System.out.println();
		System.out.println("Result:\n ");
		character.insert('J');
		System.out.println(character);
		System.out.println();

		System.out.println("Testing Duplicate Error: ");
		System.out.println("Testing Integer Variable: 72");
		System.out.println("Expected:\nNo Duplicate Items Allowed!");
		System.out.println();
		System.out.println("Result: ");
		integer.insert(72);
		System.out.println();

		//Delete Function Testing
		System.out.println("-------------------Delete Function Testing--------------------");
		System.out.println("Integer Testing: ");
		System.out.println("Testing with Integer Variable: 9");
		System.out.println("Expected: ");		
		System.out.println();
		System.out.println("                         /---- 98\r\n"
				+ "                 /---- 87\r\n"
				+ "         /---- 72\r\n"
				+ "         |       \\---- 19\r\n"
				+ " /---- 10\r\n"
				+ " |       \\---- 8\r\n"
				+ "7\r\n"
				+ " \\---- 6\r\n"
				+ "         |       /---- 5\r\n"
				+ "         \\---- 4\r\n"
				+ "                 \\---- 2");
		System.out.println();
		System.out.println("Result:\n ");
		integer.delete(9);
		System.out.println(integer);
		System.out.println();

		System.out.println("String Testing: ");
		System.out.println("Testing with String Variable: Calvin");
		System.out.println("Expected: ");
		System.out.println();
		System.out.println(" /---- Salami\r\n"
				+ " |       \\---- Interjection\r\n"
				+ " |               \\---- Honda\r\n"
				+ "Boy\r\n"
				+ " |       /---- Andrew\r\n"
				+ " \\---- Abby");
		System.out.println();
		System.out.println("Result:\n ");
		string.delete("Calvin");
		System.out.println(string);
		System.out.println();

		System.out.println("Character Testing: ");
		System.out.println("Testing with Character Variable: U");	
		System.out.println("Expected: ");
		System.out.println();
		System.out.println("/---- X\r\n"
				+ " |       \\---- L\r\n"
				+ " |               \\---- J\r\n"
				+ "I\r\n"
				+ " |               /---- G\r\n"
				+ " |       /---- E\r\n"
				+ " \\---- D");
		System.out.println();
		System.out.println("Result:\n ");
		character.delete('U');
		System.out.println(character);
		System.out.println();

		System.out.println("Testing Value Not Found Error: ");
		System.out.println("Testing with String Variable: Carlos");
		System.out.println("Expected:\nError. Given Node is not located in the Binary Search Tree.");
		System.out.println();
		System.out.println("Result: ");
		string.delete("Carlos");
		System.out.println();

		//Find Function Testing
		System.out.println("-------------------Find Function Testing--------------------");
		System.out.println("Integer Testing: ");
		System.out.println("Testing with Integer Variable: 10");
		System.out.println("Expected: true");		
		boolean ifInt = integer.find(10);		
		System.out.println("Result: " + ifInt);
		System.out.println();

		System.out.println("String Testing: ");
		System.out.println("Testing with String Variable: Play");
		System.out.println("Expected: false");		
		boolean ifString = string.find("Play");
		System.out.println("Result: " + ifString);
		System.out.println();

		System.out.println("Character Testing: ");
		System.out.println("Testing with Character Variable: E");	
		System.out.println("Expected: true");
		boolean ifChar = character.find('E');	
		System.out.println("Result: " + ifChar);
		System.out.println();

		//Preorder Function Testing
		System.out.println("-------------------Preorder Traversal Function Testing--------------------");
		System.out.println("Integer Testing: ");
		System.out.println("Expected: [7, 6, 4, 2, 5, 10, 8, 72, 19, 87, 98]");	
		ArrayList<Integer> intList = integer.preorder();
		System.out.println("Result: " + intList);
		System.out.println();

		System.out.println("String Testing: ");
		System.out.println("Expected: [Boy, Abby, Andrew, Salami, Interjection, Honda]");		
		ArrayList<String> strList = string.preorder();
		System.out.println("Result: " + strList);
		System.out.println();

		System.out.println("Character Testing: ");
		System.out.println("Expected: [I, D, E, G, X, L, J]");
		ArrayList<Character> charList = character.preorder();	
		System.out.println("Result: " + charList);
		System.out.println();

		//Inorder Function Testing
		System.out.println("-------------------Inorder Traversal Function Testing--------------------");
		System.out.println("Integer Testing: ");
		System.out.println("Expected: [2, 4, 5, 6, 7, 8, 10, 19, 72, 87, 98]");	
		intList = integer.inorder();
		System.out.println("Result: " + intList);
		System.out.println();

		System.out.println("String Testing: ");
		System.out.println("Expected: [Abby, Andrew, Boy, Honda, Interjection, Salami]");		
		strList = string.inorder();
		System.out.println("Result: " + strList);
		System.out.println();

		System.out.println("Character Testing: ");
		System.out.println("Expected: [D, E, G, I, J, L, X]");
		charList = character.inorder();	
		System.out.println("Result: " + charList);
		System.out.println();

		//Postorder Function Testing
		System.out.println("-------------------Postorder Traversal Function Testing--------------------");
		System.out.println("Integer Testing: ");
		System.out.println("Expected: [2, 5, 4, 6, 8, 19, 98, 87, 72, 10, 7]");	
		intList = integer.postorder();
		System.out.println("Result: " + intList);
		System.out.println();

		System.out.println("String Testing: ");
		System.out.println("Expected: [Andrew, Abby, Honda, Interjection, Salami, Boy]");		
		strList = string.postorder();
		System.out.println("Result: " + strList);
		System.out.println();

		System.out.println("Character Testing: ");
		System.out.println("Expected: [G, E, D, J, L, X, I]");
		charList = character.postorder();	
		System.out.println("Result: " + charList);
		System.out.println();


		//Breadthfist Function Testing
		System.out.println("-------------------Breadthfirst Traversal Function Testing--------------------");
		System.out.println("Integer Testing: ");
		System.out.println("Expected: [7, 6, 10, 4, 8, 72, 2, 5, 19, 87, 98]");	
		intList = integer.breadthfirst();
		System.out.println("Result: " + intList);
		System.out.println();

		System.out.println("String Testing: ");
		System.out.println("Expected: [Boy, Abby, Salami, Andrew, Interjection, Honda]");		
		strList = string.breadthfirst();
		System.out.println("Result: " + strList);
		System.out.println();

		System.out.println("Character Testing: ");
		System.out.println("Expected: [I, D, X, E, L, G, J]");
		charList = character.breadthfirst();	
		System.out.println("Result: " + charList);
		System.out.println();

		//isEmpty Function Testing
		System.out.println("-------------------isEmpty Function Testing--------------------");
		System.out.println("Integer Testing: ");
		System.out.println("Testing with non-empty BST");
		System.out.println("Expected: false");		
		ifInt = integer.isEmpty();		
		System.out.println("Result: " + ifInt);
		System.out.println();

		System.out.println("String Testing: ");
		System.out.println("Testing with empty BST");
		System.out.println("Expected: true");	
		ArrayList<String> newString = new ArrayList<>();
		ifString = newString.isEmpty();
		System.out.println("Result: " + ifString);
		System.out.println();

		System.out.println("Character Testing: ");
		System.out.println("Testing with empty BST");	
		System.out.println("Expected: true");
		ArrayList<Character> newChar = new ArrayList<>();
		ifChar = newChar.isEmpty();	
		System.out.println("Result: " + ifChar);
		System.out.println();
	}
}
