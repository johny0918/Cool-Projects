/* Name: Jonathan Santos 
 * Class Name: CS2013
 * Section Number: 01
 * Purpose: The main method's purpose is to receive a file from main then sent into the PPMImage constructor. Then calls the read image method to read the file to store the string, int and char types into instance variables. 
 * Then the user inputs if their image wants to be a sepia, greyscale, or negative image. The image is sent into one of those methods then sent into the writeImage method to output a file. 
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Scanner;

//ppmimage class
class PPMImage {

	//instance variables 
	private String magicNumber;
	private int width;
	private int height;
	private int maxColorValue;
	private char[] raster;
	private String imageFileName;
	private int blockSize;


	//PPImage constructor which takes a ppm image file from main
	public PPMImage(String imageFileName) throws PPMImageNotFoundException {
		this.imageFileName = imageFileName;
		//readImage method called by the constructor
		readImage(imageFileName);
	}

	//readImage class with parameters	
	private void readImage(String imageFileName) throws PPMImageNotFoundException {
		//try catch method
		try {
			//FileInputStream to open file and DateInputStream to read the binary ppm image with BufferedInputStream to increase efficiency.
			FileInputStream fis = new FileInputStream(imageFileName);
			DataInputStream dis = new DataInputStream(new BufferedInputStream(fis));

			//dis reads the first line in the binary file and sends it to the string magicNumber variable 
			magicNumber = dis.readLine();
			//dis performs a new line and then send to String newLine then to a scanner s to read the next binary data 
			String newLine = dis.readLine();
			Scanner s = new Scanner(newLine);
			//Scanner s reads the next two binary data and sends the two data into integers in width and height
			width = s.nextInt();
			height = s.nextInt();
			//newLine performed
			newLine = dis.readLine();
			s = new Scanner(newLine);
			//binary data type stored into integer maxColorValue
			maxColorValue = s.nextInt();
			int extra = 10000000;
			//blockSize to compute size of raster array
			blockSize = width * height * 3;
			//increase the size of raster array to avoid error
			raster = new char[blockSize + extra];

			//for statement to insert all binary data into char raster
			for (int i = 0; i < blockSize; i++) {
				int k = dis.read();
				//throws end of file exception if k = -1
				if(k == -1) {
					throw new EOFException("Reached End of File");
				}
				raster[i] = (char) k;
			}			
			Scanner user = new Scanner(System.in);

			//print statements to ask user whether if they want to switch image to greyscale, sepia, or negative through a number
			System.out.println("Enter 1 to switch PPM Image to Greyscale.");
			System.out.println("Enter 2 to switch PPM Image to Sepia.");
			System.out.println("Enter 3 to switch PPM Image to Negative.");
			System.out.println("Enter Number: ");

			//inputs number into inputByUser 
			int inputByUser = user.nextInt();

			//if statement to determine where to send the ppm image with multiple variables to convert them
			if (inputByUser == 1) {
				greyscale();
			} else if (inputByUser == 2) {
				sepia();
			} else if (inputByUser == 3) {
				negative();
			}

			//close file
			dis.close();
			//throws file not found or IO exception
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//greyscale method
	public void greyscale() throws PPMImageNotFoundException {
		//instance variables
		double r;
		double b;
		double g;
		double oldR;
		double oldG;
		double oldB;

		int k = 0;
		//for statement that reads the raster array and stores it into old r,g,b element
		//then the new r,g,b elements are stored into the raster element
		for (int i = 0; i < blockSize; i++) {
			//the purpose of this statement is to increment the raster array to 2 when int i becomes 1 in order to start the array at 3 instead of 2.
			if (i == 0) {
				k = 0;
			} else {
				k = k + 3; 
			}

			//1st three rgb values from raster get implemented into oldR, oldG, oldB in order
			oldR = raster[k];
			oldG = raster[k + 1];
			oldB = raster[k + 2];

			//calculations to transform the image into a greyscale
			r = (oldR * .299) + (oldG * .587) + (oldB * .114);
			g = (oldR * .299) + (oldG * .587) + (oldB * .114);
			b = (oldR * .299) + (oldG * .587) + (oldB * .114);

			//switches the old three r, g, b values from the old raster array into the new r, g, b values
			raster[k] = (char) r;
			raster[k + 1] = (char) g;
			raster[k + 2] = (char) b;

		}		
		Scanner user = new Scanner(System.in);

		//print statement that asks user to input a file name
		System.out.println("Please write the output file name (in ppm format like cat.ppm): ");
		//reads user input and implements into string user then send the file image to writeImage to write the file
		String outFile = user.nextLine();

		//checks if file inputted is a ppm image or exception will be called
		if(outFile.charAt(outFile.length() - 1) != 'm' || outFile.charAt(outFile.length() - 2) != 'p' || outFile.charAt(outFile.length() - 3) != 'p') {
			throw new PPMImageNotFoundException("Input is not a PPM file. Run Program again");
		} else {
			writeImage(outFile);
		}

	}

	//sepia method
	public void sepia() throws PPMImageNotFoundException {
		//instance variable
		double r;
		double b;
		double g;
		double oldR;
		double oldG;
		double oldB;			

		int k = 0;
		int count = 0;
		//for statement that reads the raster array and stores it into old r,g,b element
		//then the new r,g,b elements are stored into the raster element
		for (int i = 0; i < blockSize; i++) {
			count = i;
			//the purpose of this statement is to increment the raster array to 2 when int i becomes 1 in order to start the array at 3 instead of 2.
			if (i == 0) {
				k = 0;
			} else {
				k = k + 3;
			}

			//1st three rgb values from raster get implemented into oldR, oldG, oldB in order
			oldR = raster[k];
			oldG = raster[k + 1];
			oldB = raster[k + 2];

			//calculations to transform the image into a sepia
			r = (oldR * .393) + (oldG * .769) + (oldB * .189);
			g = (oldR * .349) + (oldG * .686) + (oldB * .168);
			b = (oldR * .272) + (oldG * .534) + (oldB * .131);

			//if statement invoked if r, g, b is greater than 255 then sets it into 255
			if (r > 255) {
				r = 255;
			} 
			if (g > 255) {
				g = 255;
			} 
			if (b > 255) {
				b = 255;
			}

			//switches the old three r, g, b values from the old raster array into the new r, g, b values
			raster[k] = (char) r;
			raster[k + 1] = (char) g;
			raster[k + 2] = (char) b;
			
			//if statement is invoked after i = 1 so the next loop raster[i] begins 3 arrays after the corresponding one
		}
	
		Scanner user = new Scanner(System.in);

		//print statement that asks user to input a file name
		System.out.println("Please write the output file name (in ppm format like cat.ppm): ");
		//reads user input and implements into string user then send the file image to writeImage to write the file
		String outFile = user.nextLine();
		
		//checks if file inputted is a ppm image or exception will be called
		if(outFile.charAt(outFile.length() - 1) != 'm' || outFile.charAt(outFile.length() - 2) != 'p' || outFile.charAt(outFile.length() - 3) != 'p') {
			throw new PPMImageNotFoundException("Input is not a PPM file. Run Program again");
		} else {
			writeImage(outFile);
		}
	}

	//negative method
	public void negative() throws PPMImageNotFoundException {
		//instance variables
		double r;
		double b;
		double g;
		double oldR;
		double oldG;
		double oldB;			

		int k = 0;
		//for statement that reads the raster array and stores it into old r,g,b element
		//then the new r,g,b elements are stored into the raster element
		for (int i = 0; i < blockSize; i++) {
			//the purpose of this statement is to increment the raster array to 2 when int i becomes 1 in order to start the array at 3 instead of 2.
			if (i == 0) {
				k = 0;
			} else {
				k = k + 3;
			}

			//1st three rgb values from raster get implemented into oldR, oldG, oldB in order
			oldR = raster[k];
			oldG = raster[k + 1];
			oldB = raster[k + 2];

			//calculations to transform the image into a negative
			r = (255 - oldR);
			g = (255 - oldG);
			b = (255 - oldB);

			//switches the old three r, g, b values from the old raster array into the new r, g, b values
			raster[k] = (char) r;
			raster[k + 1] = (char) g;
			raster[k + 2] = (char) b;

		}		
		Scanner user = new Scanner(System.in);

		//print statement that asks user to input a file name
		System.out.println("Please write the output file name (in ppm format like cat.ppm): ");
		//reads user input and implements into string user then send the file image to writeImage to write the file
		String outFile = user.nextLine();
		
		//checks if file inputted is a ppm image or exception will be called
		if(outFile.charAt(outFile.length() - 1) != 'm' || outFile.charAt(outFile.length() - 2) != 'p' || outFile.charAt(outFile.length() - 3) != 'p') {
			throw new PPMImageNotFoundException("Input is not a PPM file. Run Program again");
		} else {
			writeImage(outFile);
		}
	}

	//writeImage method
	public void writeImage(String outputImageFileName) {
		try {
			//FileOutputStream to create file and DataOutputStream to read file with BufferedInputStream to increase efficiency 
			FileOutputStream fos = new FileOutputStream(outputImageFileName);
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(fos));

			//writes the string variable magicNumber into bytes
			dos.writeBytes(magicNumber);
			//new line
			dos.writeBytes("\n");
			//converts integer variable width to string and writes it into bytes
			dos.writeBytes(Integer.toString(width));
			//new line
			dos.writeBytes(" ");
			//converts integer variable height to string and writes it into bytes
			dos.writeBytes(Integer.toString(height));
			// new line
			dos.writeBytes("\n");
			//converts integer variable maxColorValue to string and writes it into bytes
			dos.writeBytes(Integer.toString(maxColorValue));
			dos.writeBytes("\n");

			//for statement to write the converted raster array into the new file 
			for (int i = 0; i < blockSize; i++) {
				int y = raster[i];
				
				//checks if the file ended and throws the EOF exception
				if (y == -1) {
					throw new EOFException("Reached End of File");
				}
				
				//write raster char bytes into file
				dos.write(raster[i]);
			}

			//close file
			dos.close();

			//print statement that shows the file is created
			System.out.println("The file " + outputImageFileName + " has been created");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//getter methods
	public String getImageFileName() {
		return imageFileName;
	}
	//setter methods
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

}
