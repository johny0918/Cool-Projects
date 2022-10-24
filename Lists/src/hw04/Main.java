/* Your Name: Jonathan Santos
 * Your Course Number: CS2013
 * Your Section Numbers: 01
 * Description: The purpose of this class is to test the various methods in the SortedSet class
 */

package hw04;

public class Main {
	public static void main(String[] args) {
		//instance variables
		SortedSet<Integer> integer = new SortedSet<> (1, 2, 3, 5, 7, 34, 54, 57, 69, 73);
		SortedSet<Character> character = new SortedSet<> ('a', 'd', 'f', 'g', 'h', 'l', 'o', 'y', 'z');
		SortedSet<String> string = new SortedSet<> ("Abby", "Cisco", "Disco", "Flaco", "Ghost", "Johnny", "Kate", "Polio", "Xavier", "Zoey");

		//print initial arrays
		System.out.println("----------------Initial Arrays-------------- ");
		System.out.println("Integer Array: " + integer);
		System.out.println("Character Array: " + character);
		System.out.println("String Array: " + string);
		System.out.println();

		//print exists method testings
		System.out.println("---------------Exists Method Testing-----------------");
		System.out.println();
		System.out.println("Integer Array Testing: ");
		System.out.println("Testing with integer: 0");
		System.out.println("Expected: false");
		boolean inExists = integer.exists(0);
		System.out.println("Results: " + inExists);
		System.out.println();

		System.out.println("Character Array Testing: ");
		System.out.println("Testing with character: g");
		System.out.println("Expected: true");
		boolean chExists = character.exists('g');
		System.out.println("Results: " + chExists);
		System.out.println();

		System.out.println("String Array Testing: ");
		System.out.println("Testing with string: Jack");
		System.out.println("Expected: false");
		boolean stExists = string.exists("Jack");
		System.out.println("Results: " + stExists);
		System.out.println();

		//print add method testings
		System.out.println("---------------Add Method Testing----------------");
		System.out.println();
		System.out.println("Integer Array Testing: ");
		System.out.println("Testing with integer: 12");
		System.out.println("Expected: {1, 2, 3, 5, 7, 12, 34, 54, 57, 69, 73}");
		integer.add(12);
		System.out.println("Result: " + integer);
		System.out.println();

		System.out.println("Character Array Testing: ");
		System.out.println("Testing with character: b");
		System.out.println("Expected: {a, b, d, f, g, h, l, o, y, z}");
		character.add('b');
		System.out.println("Result: " + character);
		System.out.println();

		System.out.println("String Array Testing: ");
		System.out.println("Testing with string: Bob");
		System.out.println("Expected: {Abby, Bob, Cisco, Disco, Flaco, Ghost, Johnny, Kate, Polio, Xavier, Zoey}");
		string.add("Bob");
		System.out.println("Result: " + string);
		System.out.println();

		//print add all method testings
		System.out.println("---------------AddAll Method Testing---------------");
		System.out.println();
		System.out.println("Integer Array Testing: ");
		System.out.println("Testing with integer: 32, 37, 63, 22");
		System.out.println("Expected: {1, 2, 3, 5, 7, 12, 22, 32, 34, 37, 54, 57, 63, 69, 73}");
		integer.addAll(32, 37, 63, 22);
		System.out.println("Result: " + integer);
		System.out.println();

		System.out.println("Character Array Testing: ");
		System.out.println("Testing with character: e, i, j");
		System.out.println("Expected: {a, b, d, e, f, g, h, i, j, l, o, y, z}");
		character.addAll('e', 'i', 'j');
		System.out.println("Result: " + character);
		System.out.println();

		System.out.println("String Array Testing: ");
		System.out.println("Testing with string: Edgar, Hank, John");
		System.out.println("Expected: {Abby, Bob, Cisco, Disco, Edgar, Flaco, Ghost, Hank, John, Johnny, Kate, Polio, Xavier, Zoey}");
		string.addAll("Edgar", "Hank", "John");
		System.out.println("Result: " + string);
		System.out.println();

		//print equals method testing
		System.out.println("-------------Equals Method Testing--------------");
		System.out.println();
		System.out.println("Integer Array Testing: ");
		System.out.println("Testing with Integer: both same array");
		System.out.println("Expected: true");
		boolean isInt = integer.equals(integer);
		System.out.println("Result: " + isInt);
		System.out.println();

		System.out.println("Character Array Testing: ");
		System.out.println("Testing with character: previous array to {a, d, f, g, h, l, o, z}");
		System.out.println("Expected: false");
		SortedSet<Character> charact = new SortedSet<> ('a', 'd', 'f', 'g', 'h', 'l', 'o', 'z');
		boolean isChr = character.equals(charact);
		System.out.println("Result: " + isChr);
		System.out.println();

		System.out.println("String Array Testing: ");
		System.out.println("Testing with string: both same array");
		System.out.println("Expected: true");
		boolean isStr = string.equals(string);
		System.out.println("Result: " + isStr);
		System.out.println();

		//print get method testings
		System.out.println("--------------Get Method Testing-------------");
		System.out.println();
		System.out.println("Integer Array Testing: ");
		System.out.println("Testing with Index: 3");
		System.out.println("Expected: 5");
		int getInteger = integer.get(3);
		System.out.println("Result: " + getInteger);
		System.out.println();

		System.out.println("Character Array Testing: ");
		System.out.println("Testing with Index: 5");
		System.out.println("Expected: g");
		char getChar = character.get(5);
		System.out.println("Result: " + getChar);
		System.out.println();

		System.out.println("String Array Testing: ");
		System.out.println("Testing with Index: 9");
		System.out.println("Expected: Johnny");
		String getStr = string.get(9);
		System.out.println("Result: " + getStr);
		System.out.println();

		//print remove method testings
		System.out.println("-------------Remove Method Testing-------------");
		System.out.println();
		System.out.println("Integer Array Testing: ");
		System.out.println("Testing with integer: 32");
		System.out.println("Expected: {1, 2, 3, 5, 7, 12, 22, 34, 37, 54, 57, 63, 69, 73}");
		integer.remove(32);
		System.out.println("Result: " + integer);
		System.out.println();

		System.out.println("Character Array Testing: ");
		System.out.println("Testing with character: f");
		System.out.println("Expected: {a, b, d, e, g, h, i, j, l, o, y, z}");
		character.remove('f');
		System.out.println("Result: " + character);
		System.out.println();

		System.out.println("String Array Testing: ");
		System.out.println("Testing with string: Sam");
		System.out.println("Expected: Element is not in the array");
		System.out.println("Result: ");
		string.remove("Sam");
		System.out.println();

		//print size method testings
		System.out.println("---------------Size Method Testing--------------");
		System.out.println();
		System.out.println("Integer Array Testing: ");
		int i = integer.size();
		System.out.println("Size of Integer array: " + i);
		System.out.println();

		System.out.println("Character Array Testing: ");
		int c = character.size();
		System.out.println("Size of Character Array: " + c);
		System.out.println();

		System.out.println("String Array Size: ");
		int s = string.size();
		System.out.println("Size of String Array: " + s);
		System.out.println();

		//prints union method testings
		System.out.println("----------------Union Method Testing-----------------");
		System.out.println();
		System.out.println("Integer Array Testing: ");
		System.out.println("Testing with: (1, 3, 5, 6, 11, 28, 30) & (2, 4, 10, 21, 24, 28, 25)");
		System.out.println("Expected: {1, 2, 3, 4, 5, 6, 10, 11, 21, 24, 25, 28, 30}");
		SortedSet int1 = new SortedSet<> (1, 3, 5, 6, 11, 28, 30);
		SortedSet int2 = new SortedSet<> (2, 4, 10, 21, 24, 25, 28);
		SortedSet intUnion = SortedSetUtils.union(int1, int2);
		System.out.println("Result: " + intUnion);
		System.out.println();
		
		System.out.println("Character Array Testing: ");
		System.out.println("Testing with: ('a', 'd', 'f' ,'h') & ('b', 'c', 'f', 'e', 'g', 'k')");
		System.out.println("Expected:  {a, b, c, d, e, f, g, j, k, l, y}");
		SortedSet char1 = new SortedSet<> ('a', 'd', 'f' , 'j', 'l','y');
		SortedSet char2 = new SortedSet<> ('b', 'c', 'f', 'e', 'g', 'k');
		SortedSet charUnion = SortedSetUtils.union(char1, char2);
		System.out.println("Result: " + charUnion);
		System.out.println();
		
		System.out.println("String Array Testing: ");
		System.out.println("Testing with: (\"Aaron\", \"Bill\", \"Chicken\", \"Dog\", \"James\", \"Nate\", \"Serena\") + (\"Andrew\", \"Carlos\", \"Emmanuel\", \"Jamaal\", \"Kangaroo\")");
		System.out.println("Expected: {Aaron, Andrew, Bill, Carlos, Chicken, Dog, Emmanuel, Jamaal, James, Kangaroo, Nate, Serena}");
		SortedSet str1 = new SortedSet<> ("Aaron", "Bill", "Chicken", "Dog", "James", "Nate", "Serena");
		SortedSet str2 = new SortedSet<> ("Andrew", "Carlos", "Emmanuel", "Jamaal", "Kangaroo");
		SortedSet strUnion = SortedSetUtils.union(str1, str2);
		System.out.println("Result: " + strUnion);
		System.out.println();
		
		System.out.println("------------------------------Intersection Method Testing----------------------------");
		System.out.println();
		System.out.println("Integer Array Testing: ");
		System.out.println("Testing with: (1, 2, 3, 7, 8, 5) & (0, 2, 3, 8, 9)");
		System.out.println("Expected: {2, 3, 8}");
		int1 = new SortedSet<> (1, 2, 3, 7, 8, 5);
		int2 = new SortedSet<> (0, 2, 3, 8, 9);
		intUnion = SortedSetUtils.intersection(int1, int2);
		System.out.println("Result: " + intUnion);
		System.out.println();
		
		System.out.println("Character Array Testing: ");
		System.out.println("Testing with: (c, k, j, l, w) & (a, d, e, k, y, j, u, c)");
		System.out.println("Expected: {c, j, k}");
		char1 = new SortedSet<> ('c', 'k', 'j', 'l', 'w');
		char2 = new SortedSet<> ('a', 'd', 'e', 'k', 'y', 'j', 'u', 'c');
		charUnion = SortedSetUtils.intersection(char1, char2);
		System.out.println("Result: " + charUnion);
		System.out.println();
		
		System.out.println("String Array Testing: ");
		System.out.println("Testing with: (Andy, Calvin, Sally, Ghost, Matthew) & (Abby, Bob, Calvin, Josh, Ghost)");
		System.out.println("Expected: {Calvin, Ghost}");
		str1 = new SortedSet<> ("Andy", "Calvin", "Sally", "Ghost", "Mathew");
		str2 = new SortedSet<> ("Abby", "Bob", "Calvin", "Josh", "Ghost");
		strUnion = SortedSetUtils.intersection(str1, str2);
		System.out.println("Result: " + strUnion);
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
}
