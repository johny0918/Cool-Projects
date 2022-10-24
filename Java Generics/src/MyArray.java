/* Your Name: Jonathan Santos 
 * Your Course Number: CS2013 
 * Your Section Number: 01
 * Description: The purpose of this class is to perform the generic methods called from the main class
 */
import java.util.Random;

public class MyArray<E extends Comparable<E>> {
	//No other data fields necessary.
	private E[] data;

	public MyArray(int size) {
		this.data = (E[])(new Comparable[size]);
	}

	//This constructor can accept an array or a comma-separated list of values.
	public MyArray(E ... elements) {
		this.data = (E[])(new Comparable[elements.length]);
		//Make a deep copy to prevent shared references.
		System.arraycopy(elements, 0, this.data, 0, elements.length);
	}

	//get method that takes an integer index and returns data at given index
	public E get(int index) {
		return data[index];
	}

	//MyArray get method that returns the wanted array called by the main class
	public MyArray <E> get(int start, int end) {
		//instance variable
		int k = 0;
		int extra = 1;
		MyArray <E> middleIndex = new MyArray<E>((end - start) + extra);
		//for loop that sends the Array middleIndex to the put method
		for (int i = start; i <= end; i++) {
			middleIndex.put(k, data[i]);
			k++;
		}
		//return statement
		return middleIndex;
	}

	//put method called from myarray get method
	public void put(int index, E value) {
		data[index] = value;
	}

	//put method that takes three parameters and places multiple elements in a specific range
	public void put(int start, int end, E...values) {
		//for loop that adds the values in the proper indices
		for (int i = 0; i < values.length; i++) {
			put(start + i, values[i]);
		}
	}

	//boolen equals method that compares two arrays and returns if the arrays are equal or not 
	@Override
	public boolean equals(Object input) {
		//instance variable
		MyArray<E> i = (MyArray<E>) input;
		//loops until it reaches the array's end 
		for (int j = 0; j < data.length; j++) {
			//if the input myarray object equals to the parameter myarray object
			if (i.data[j] == this.data[j]) {
				//do nothing
			} else {
				//return statement
				return false;
			}
		}
		//return statement
		return true;
	}

	//max method that determines the max in an array
	public E max() {
		//instance variable
		E temp = data[0];
		//for loop that stops at the end of array
		for (int i = 0; i < data.length; i++) {
			//compare statement that determines the maximum in array
			if (temp.compareTo(data[i]) < 0) {
				//stores max in variable
				temp = data[i];
			}
		}
		//return statement
		return temp;
	}

	//min method that determines minimum in array
	public E min() {
		//instance variable
		E temp = data[0];
		//loop ends at half of the array
		for (int i = 0; i < data.length; i++) {
			//compare statement that determines minimum in array
			if (temp.compareTo(data[i]) > 0) {
				//stores min in variable
				temp = data[i];
			}
		}
		//return statement
		return temp;
	}

	//reverse method that reverses array
	public void reverse() {
		//instance variable
		E temp;
		//loop ends at halfway of the array
		for (int i = 0; i < data.length / 2; i++) {
			//stores current element to temp 
			temp = data[i];
			//stores (final - current) element into  into current element 
			data[i] = data[data.length - i - 1];
			//stores current element into (final - current) element 
			data[data.length - i - 1] = temp;
		}
	}

	//shuffle method that shuffles the array the array
	public void shuffle() {
		//instance variables
		Random rand = new Random();
		int random;
		E temp;
		//loop ends until array ends
		for (int i = 0; i < data.length; i++) {
			//stores random element from array into random variable
			random = rand.nextInt(data.length);
			//stores current element into temp variabale
			temp = data[i];
			//stores random element into current array
			data[i] = data[random];
			//stores current element into random element 
			data[random] = temp;
		}
	}

	//left shift method which shifts array to the left
	public void leftShift(int shiftDistance) {	
		//loop ends until shift distance is reached
		for (int i = 0; i < shiftDistance; i++) {
			//stores first element into temp variable
			E temp = data[0];
			//sends next element into the previous element in the array
			for (int j = 0; j < data.length - 1; j++) {
				data[j] = data[j + 1];
			}
			//stores first element in array into final element 
			data[data.length - 1] = temp;
		}
	}

	//right shift method that shifts array to the right
	public void rightShift(int shiftDistance) {
		//for loop that that ends when shift distance is reaches
		for (int i = 0; i < shiftDistance; i++) {
			//final element is stored into variable temp 
			E temp = data[data.length - 1];
			//sends previous element into current element in array
			for (int j = data.length - 1; j > 0; j--) {
				data[j] = data[j - 1];
			}
			//sends final element into first element 
			data[0] = temp;
		}
	}

	//size method that returns size of array
	public int size() {
		return data.length;
	}

	//to String method which returns the array as a string seperated by commas 
	public String toString() {
		String s = "";
		for (int i = 0; i < data.length; i++) {
			s += data[i];
			if (i != data.length - 1) {
				s += ", ";
			}
		}

		return s;
	}

	//sort method which sorts the array in order
	public void sort() {
		//instance variable
		boolean sorted = false;
		E temp;
		//loop ends until sorted is true
		while (sorted == false) {
			//both loops end until array ends
			for (int i = 0; i < data.length - 1; i++) {
				for (int j = i + 1; j < data.length; j++) {
					//compare statement which swaps minimum element into the previous element 
					if (data[i].compareTo(data[j]) > 0) {
						temp = data[i];
						data[i] = data[j];
						data [j] = temp;
					}
				}

			}
			//ends while loop
			sorted = true;
		}

	}
}
