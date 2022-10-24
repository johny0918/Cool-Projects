/* Your Name: Jonathan Santos
 * Your Course Number: CS2013
 * Your Section Numbers: 01
 * Description: The purpose of this class is to perform the union and intersection method
 */

package hw04;

import java.util.Arrays;

///sortedsetutils class
public class SortedSetUtils {
	//default constructor 
	private SortedSetUtils() {}

	//union class 
	public static <E extends Comparable<E>> SortedSet union(SortedSet sortedSet1, SortedSet sortedSet2) {
		//initializing generic array with wildcard to avoid a classcastexception
		E[] ss2 = (E[]) new Comparable<?>[sortedSet2.size()];
		SortedSet unionObject = null;
		//copies my sortedSet2 object into generic array
		for (int i = 0; i < sortedSet2.size(); i++) {
			ss2[i] = (E) sortedSet2.get(i);
		}

		//testing
		sortedSet1.addAll(ss2); 
		unionObject = sortedSet1;


		//return statement
		return unionObject;

	}

	public static <E extends Comparable<E>> SortedSet intersection(SortedSet sortedSet1, SortedSet sortedSet2) {
		//local variables
		int count;
		int size1;
		int size2;
		//generic array initializtion
		E[] ss1 = (E[]) new Comparable<?>[sortedSet1.size()];
		E[] ss2 = (E[]) new Comparable<?>[sortedSet2.size()];
		E[] tempObject = (E[]) new Comparable<?>[sortedSet2.size()];
		SortedSet unionObject = new SortedSet<>();
		//copies sortedSet1 into temp generic array
		for (int i = 0; i < sortedSet1.size(); i++) {
			ss1[i] = (E) sortedSet1.get(i);
		}
		//copies sortedSet2 into temp generic array
		for (int i = 0; i < sortedSet2.size(); i++) {
			ss2[i] = (E) sortedSet2.get(i);
		}

		//initializing size variables
		size1 = sortedSet1.size();
		size2 = sortedSet2.size();

		//checks if both sizes are equal to each other
		if (size1 == size2) {
			count = 0;
			tempObject = (E[]) new Comparable<?>[size1];
			//finds which elemnts are equal to each other and stores in temporary generic array
			for (int i = 0; i < size1; i++) {
				if (sortedSet1.exists(ss2[i])) {
					tempObject[count] = ss2[i];
					count++;
				}
			}
		//checks if size1 > size2
		} else if (size1 > size2) {
			count = 0;
			tempObject = (E[]) new Comparable<?>[size2];
			//finds which elemnts are equal to each other and stores in temporary generic array
			for (int i = 0; i < size2; i++) {
				if (sortedSet1.exists(ss2[i])) {
					tempObject[count] = ss2[i];
					count++;
				}					
			}
		//else statement 
		} else {
			count = 0;
			tempObject = (E[]) new Comparable<?>[size1];
			//finds which elemnts are equal to each other and stores in temporary generic array
			for (int i = 0; i < size1; i++) {
				if (sortedSet2.exists(ss1[i])) {
					tempObject[count] = ss1[i];
					count++;
				}
			}
		}
		//sorts temp generic array
		Arrays.sort(tempObject, 0, count);
		unionObject.addAll(tempObject);
		
		//return statement
		return unionObject;

	}
}