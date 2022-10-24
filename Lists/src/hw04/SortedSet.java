/* Your Name: Jonathen Santos 
 * Your Course Number: CS2013
 * Your Section Numbers: 01
 * Description: The purpose of this class is to perform the multiple generic methods to change the set
 */

package hw04;

import java.util.Arrays;

//sortedset class
public class SortedSet<E extends Comparable<E>> {
	//data fields
	private int size = 0;
	private E[] set = (E[])(new Comparable[size]);

	//default constructor
	public SortedSet() {
		set = (E[])(new Comparable[10]);
	}

	//constructor that accepts an integer
	public SortedSet(int size) {
		set = (E[])(new Comparable[size]);
		this.size = size;
	}

	//constructor that accepts an array or comma-seperated list of values
	public SortedSet(E ... values) {
		set = (E[])(new Comparable[values.length]);
		System.arraycopy(values, 0, set, 0, values.length);
		Arrays.sort(set, 0, values.length);
		//initializing size
		if (this.size == 0) {
			this.size = values.length;
		}
	}

	//copy constructor
	public SortedSet(SortedSet ss) {
		//Makes a deep copy to prevent shared references
		ss.size();
		System.arraycopy(ss, 0, this.set, 0, ss.size());
	}

	//resize method
	private void resize() {
		//initializing a temporary generic array
		E[] tempSet =  (E[])(new Comparable[this.set.length * 2]);
		//copy from old set to new set then send new set to this.set
		for (int i = 0; i < size; i++) {
			tempSet[i] = set[i];
		}
		this.set = tempSet;
	}

	//exists method
	public boolean exists(E input) {
		//local variable
		int low = 0;
		int high = size;

		//checks whether the input is out of range and returns false
		if (set[0] == null) {
			return false;
		} else if (input.compareTo(set[0]) < 0) {
			return false;
		} else if (set[size - 1] != null) {
			if (input.compareTo(set[size - 1]) > 0) {
				return false;
			}
		}


		//binary search
		while (low <= high) {

			//initialize middle value with the middle of the set 
			int mid = (low + high) / 2;
			E midValue = set[mid];
			//converts the comparison of input and midvalue into an int and assign it into result
			int result = input.compareTo(midValue);

			//checks whether result is equal to check if the input exists within the set
			if (result == 0) {
				return true;
			} else if (result > 0) {
				low = mid + 1;
			}
			else if (result < 0) {
				high = mid - 1;
			}
		}
		//return statement
		return false;
	}

	//add method
	public void add(E value) {
		//checks whether if capacity is equal to size to resize or not
		if (set.length == size) {
			resize();
		}
		//checks if value exists in the set
		if (exists(value)) {
			//do nothing
		} else {
			if (set[0] == null) {
				set[0] = value;
			} else {
				//checks if value is less than first value 
				if (value.compareTo(set[0]) < 0) {
					E temp = set[size - 1];
					//performs right shift
					for (int j = size - 1; j > 0; j--) {
						set[j] = set[j - 1];
					}
					//places first and last value in correct place
					set[0] = value;
					set[size] = temp;
					//increments size
					size += 1;
					//checks if value is greater than last value
				} else if (value.compareTo(set[size - 1]) > 0) {
					//places value at last index
					set[size] = value;
					//increments size
					size += 1;
				} else {
					//loops until reaches size length
					for (int i = 0; i < size; i++) {
						//checks if value is between current and next position value
						if (value.compareTo(set[i]) > 0 && value.compareTo(set[i + 1]) < 0) {
							E temp = set[size - 1];
							//shifts elements to the right
							for (int j = size - 1; j > i; j--) {
								set[j] = set[j - 1];
							}
							//places intended and last value in correct place
							set[i + 1] = value;
							set[size] = temp;	
							//increments size
							size += 1;
						}
					}
				}
			}
		}

	}

	//addAll method
	public void addAll(E ... values) {
		//sends to resize method if capacity and size is equal
		if(set.length == size) {
			resize();
		}
		//checks if list is empty 
		if (set[0] == null) {
			//inputs given values into empty list
			for (int i = 0; i < values.length; i++) {
				set[i] = values[i];
				if (set[i] != null) {
					size++;
				}
			}
		} else {		
			//sends each individual value to add method
			for (int i = 0; i < values.length; i++) {
				add(values[i]);		
			}
		}
	}

	//remove method
	public void remove(E value) {
		//sends to resize method if capacity and size is equal
		if (set.length == size) {
			resize();
		}
		//checks if value exists in the set
		if (exists(value) == false) {
			System.out.println("Element is not in the array");
		} else {
			//for loop which checks which value to eliminate and right shifts array from eliminated value 
			for (int i = 0; i < size; i++) {
				//checks which index to remove and begins the for loop to shift the array 
				if (value.compareTo(set[i]) == 0) {
					for (int j = i; j < size; j++) {
						set[j] = set[j + 1];
					}
					//subtract size by 1
					size--;
					break;
				}
			}
		}
	}

	//returns value stored in index
	public E get(int index) throws IndexOutOfBoundsException{
		return set[index];
	}

	//equals array 
	@Override
	public boolean equals(Object input) {
		if(size == set.length) {
			resize();
		}
		//local generic array
		SortedSet<E> i = (SortedSet<E>) input;
		//loops until it reaches the array's end
		for (int j = 0; j < size; j++) {
			//if the input sortedset object equals to the parameter sortedset object
			if (i.set[j] == this.set[j]) {
				//do nothing
			} else {
				//return statement
				return false;
			}
		}
		//return statement
		return true;

	}

	//return size of set
	public int size() {
		return size;
	}

	//to String method which returns set as a string seperated by commas
	public String toString() {
		if (set.length == size) {
			resize();
		}
		String s = "{";
		if (set.length == 0) {
			return "{}";
		}
		for (int i = 0; i < size; i++) {
			if (this.set[i] != null) {
				s += set[i];
			}
			if (i + 1 < size) {
				s += ", ";
			}
		}
		s += "}";
		return s;
	}
}