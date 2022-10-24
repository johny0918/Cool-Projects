/* Your Name: Jonathan Santos 
 * Your Course Number: CS2013 
 * Your Section Number: 01
 * Description: The purpose of the main method class is to call the various methods in the MyArray class
 */

public class Main {
	public static void main(String[] args) {
		//instance variables
		MyArray<String> string = new MyArray<> ("Apple", "Spider", "Chicken", "Magma", "Spinach");
		MyArray<Character> character = new MyArray<> ('P', '!', 'Q', '.', ',', 'F');
		MyArray<Integer> integer = new MyArray<> (3, 4, 5, 15, 93, 27, 87);

		//prints arrays for string, character, and integer
		System.out.println("String Array: " + string);
		System.out.println("Char Array: " + character);
		System.out.println("Integer Array: " + integer);
		System.out.println();

		//prints string, character, and integer array called from get method
		System.out.println("Using the get Method for String: ");
		MyArray getStringArray = string.get(1, 3);
		System.out.println("New String Array: " + getStringArray);
		System.out.println();

		System.out.println("Using the get Method for Character: ");
		MyArray getCharacterArray = character.get(1, 2);
		System.out.println("New Character Array: " + getCharacterArray);
		System.out.println();

		System.out.println("Using the get Method for Integer: ");
		MyArray getIntegerArray = integer.get(2, 5);
		System.out.println("New Integer Array: " + getIntegerArray);
		System.out.println();

		//prints true or false statement for equals method from string, character, and integer arrays
		System.out.println("Using the equals Method for String: ");
		boolean equalStringArray = getStringArray.equals(string);
		System.out.println("Is original string array equal to new string array: " + equalStringArray);
		System.out.println();

		System.out.println("Using the equals Method for Character: ");
		boolean equalCharacterArray = character.equals(character);
		System.out.println("Is original character array equal to new character array: " + equalCharacterArray);
		System.out.println();

		System.out.println("Using the equals Method for Integer: ");
		MyArray newIntegerArray = new MyArray<> (1, 3, 5, 9, 2);
		boolean equalIntegerArray = integer.equals(newIntegerArray);
		System.out.println("Is original integer array equal to new integer array: " + equalIntegerArray);
		System.out.println();

		//prints minimum in the string, character, and integer arrays
		System.out.println("Using min method for String, Integer, and Character: ");
		System.out.println("Minimum for String: " + string.min());
		System.out.println("Minimum for Character: " + character.min());
		System.out.println("Minimum for Integer: " + integer.min());
		System.out.println();

		//prints maximum in the string, character, and integer arrays
		System.out.println("Using max method for String, Integer, and Character: ");
		System.out.println("Maximum for String: " + string.max());
		System.out.println("Maximum for Character: " + character.max());
		System.out.println("Maximum for Integer: " + integer.max());
		System.out.println();

		//prints reverse arrays for the original string, character, and integer array
		System.out.println("Using reverse method for String: ");
		System.out.println("Original String Array: " + string);
		string.reverse();
		System.out.println("New String Array: " + string);
		System.out.println();

		System.out.println("Using reverse method for Character: ");
		System.out.println("Original Character Array: " + character);
		character.reverse();
		System.out.println("New Character Array: " + character);
		System.out.println();

		System.out.println("Using reverse method for Integer: ");
		System.out.println("Original Integer Array: " + integer);
		integer.reverse();
		System.out.println("New Integer Array: " + integer);
		System.out.println();

		//re-instantiate original variables 
		string = new MyArray<> ("Apple", "Spider", "Chicken", "Magma", "Spinach");
		character = new MyArray<> ('P', '!', 'Q', '.', ',', 'F');
		integer = new MyArray<> (3, 4, 5, 15, 93, 27, 87);

		//print shuffle array for string, character, and integer arrays
		System.out.println("Using shuffle method for String: ");
		System.out.println("Original String Array: " + string);
		string.shuffle();
		System.out.println("New String Array: " + string);
		System.out.println();

		System.out.println("Using shuffle method for Character: ");
		System.out.println("Original Character Array: " + character);
		character.shuffle();
		System.out.println("New Character Array: " + character);
		System.out.println();

		System.out.println("Using shuffle method for Integer: ");
		System.out.println("Original Integer Array: " + integer);
		integer.shuffle();
		System.out.println("New Integer Array: " + integer);
		System.out.println();

		//re-instantiate variables
		string = new MyArray<> ("Apple", "Spider", "Chicken", "Magma", "Spinach");
		character = new MyArray<> ('P', '!', 'Q', '.', ',', 'F');
		integer = new MyArray<> (3, 4, 5, 15, 93, 27, 87);

		//print left shift for string, character, and integer arrays
		System.out.println("Using left shift for String: ");
		System.out.println("Original String Array: " + string);
		string.leftShift(1);
		System.out.println("New String Array: " + string);
		System.out.println();

		System.out.println("Using left shift for Character: ");
		System.out.println("Original Character Array: " + character);
		character.leftShift(2);
		System.out.println("New Character Array: " + character);
		System.out.println();

		System.out.println("Using left shift for Integer: ");
		System.out.println("Original Integer Array: " + integer);
		integer.leftShift(3);
		System.out.println("New Integer Array: " + integer);
		System.out.println();

		//re-instantiate variables 
		string = new MyArray<> ("Apple", "Spider", "Chicken", "Magma", "Spinach");
		character = new MyArray<> ('P', '!', 'Q', '.', ',', 'F');
		integer = new MyArray<> (3, 4, 5, 15, 93, 27, 87);

		//print right shift for string, character, and integer arrays
		System.out.println("Using right shift for String: ");
		System.out.println("Original String Array: " + string);
		string.rightShift(2);
		System.out.println("New String Array: " + string);
		System.out.println();

		System.out.println("Using right shift for Character: ");
		System.out.println("Original Character Array: " + character);
		character.rightShift(3);
		System.out.println("New Character Array: " + character);
		System.out.println();

		System.out.println("Using right shift for Integer: ");
		System.out.println("Original Integer Array: " + integer);
		integer.rightShift(1);
		System.out.println("New Integer Array: " + integer);
		System.out.println();
		
		//print size for string, character, and integer arrays
		System.out.println("Using size method for Integer, String, and Character: ");
		System.out.println("String Array Size: " + string.size());
		System.out.println("Character Array Size: " + character.size());
		System.out.println("Integer Array Size: " + integer.size());
		System.out.println();

		//print sort arrays for the string, character, and integer arrays
		System.out.println("Using sort method for String: ");
		System.out.println("Previous String Array: " + string);
		string.sort();
		System.out.println("New String Array: " + string);
		System.out.println();

		System.out.println("Using sort method for Character: ");
		System.out.println("Previous Character Array: " + character);
		character.sort();
		System.out.println("New Character Array: " + character);
		System.out.println();

		System.out.println("Using sort method for Integer: ");
		System.out.println("Previous Integer Array: " + integer);
		integer.sort();
		System.out.println("New Integer Array: " + integer);
		System.out.println();
	}
}
