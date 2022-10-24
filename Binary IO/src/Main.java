/* Jonathan Santos 
 * CS2013
 * Section Number 01
 * Purpose: The main method's purpose is to invoke a statement where the user must input a ppm image file. 
 */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws PPMImageNotFoundException {
		//instance variables
		PPMImage ppm;
		String inFile;
		
		//Scanner user to input user's image
		Scanner user = new Scanner(System.in);
		//print statement to ask user to enter ppm image
		System.out.println("Please enter a PPM Image (for example like cat.ppm or sport.ppm): ");
		//scanner user reads input and sends it into inFile string and then sends it into PPMImage class and constructor
		inFile = user.nextLine();
		
		//if statement to invoke if the file inputted is a ppm file, if not a ppm file then an exception will be called
		if(inFile.charAt(inFile.length() - 1) != 'm' || inFile.charAt(inFile.length() - 2) != 'p' || inFile.charAt(inFile.length() - 3) != 'p') {
			throw new PPMImageNotFoundException("Input is not a PPM file. Run Program again");
		} else {
			ppm = new PPMImage(inFile);
		}
	}
}
