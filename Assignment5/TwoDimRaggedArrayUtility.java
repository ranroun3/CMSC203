import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * CMSC 203 CRN 47229
 * Assignment 5
 * Dr. Grinberg
 * @author RonyStephan
 * Description: This class serves as a utility class to manipulate 2d ragged arrays
 */
public class TwoDimRaggedArrayUtility {
	/**
	 * This utility works with 2 dimensional ragged arrays with a maximum of 10 rows and 10 columns
	This utility works with negative and positive numbers
	This is a utility class - there are no private data members
	 */
	public TwoDimRaggedArrayUtility(){

	}

	/**
	 * Reads from a file and returns a ragged array of doubles 
	 * The maximum rows is 10 and the maximum columns for each row is 10 
	 * Each row in the file is separated by a new line
	 * Each element in the row is separated by a space
	 *  Suggestion: You need to know how many rows and how many columns there are for each row to create a ragged array.
	 *   1. Read the doubles from the file into an a temporary array [10][10] of Strings which was initialized to nulls.
	 *   2. Find out how many rows there are (any row that has the first element != null is a valid row)
	 *   3. Create the array based on the num of rows, i.e. double[][]array = new double[#rows][]
	 *   4. Determine the number of columns for the first row (any element != null is a valid element)
	 *   5. Create the first row, i.e. array[0] = new double[#columns] 
	 *   6. Put the values from the temporary array into in the row (don't forget to convert from strings to doubles)
	 *   7. Repeat for all rows
	 * @param file the file to read from
	 * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty, returns a null if file is empty
	 * @throws FileNotFoundException if file is not found
	 */
	public static double[][] readFile(File file) throws FileNotFoundException{
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		Scanner in = new Scanner(file);
		//int intLength = 0;
		int counter=0;

		//STEP 1
		String[][] tempArr = new String[10][10]; //create new array of strings
		while(in.hasNextLine()&&counter<10) { //while there is another line 
			tempArr[counter] = in.nextLine().trim().split("\\s+"); //add split strings to current array location
			counter++;
		}

		//STEP 2
		int rowCount=0;
		for(int i=0; i<10; i++) {
			if(tempArr[i][0]!=null) { //counting non-empty rows
				rowCount++;
			}
		}

		//STEP 3
		double [][]array = new double[rowCount][]; //step 3
		
		//STEP 4
	//	int newRowCount=0;
		for(int i=0; i<rowCount; i++) {
			int columnCount=0;
			
			for(int j=0; j<tempArr[i].length; j++) {
				if(tempArr[i][j] !=null) {
					columnCount++;
				}	
			}
			array[i]= new double[columnCount];
			for(int j=0; j<columnCount; j++) {
				array[i][j]=Double.parseDouble(tempArr[i][j]);
			}
		}
		return array;
	}

	/**
	 * Writes the ragged array of doubles into the file.
	 * Each row is on a separate line within the file and each double is separated by a space.
	 * @param data two dimensional ragged array of doubles
	 * @param outputFile the file to write to
	 * @throws FileNotFoundException if outputFile is not valid
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException{
		try {
		FileWriter fw= new FileWriter(outputFile, true);
		BufferedWriter myWriter = new BufferedWriter(fw);
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				myWriter.write(Double.toString(data[i][j]));
				myWriter.write(" ");
			}
			myWriter.newLine();
		}
		myWriter.close();
		}
		catch(Exception e) {
			throw new FileNotFoundException();
		}
	}

	/**
	 * Returns the total of all the elements of the two dimensional array
	 * @param data the two dimensional array getting total of
	 * @return the sum of all the elements in the two dimensional array
	 */

	public static double getTotal(double[][] data) {
		double total =0;
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				total+=data[i][j];
			}
		}
		return total;
	}

	/**
	 * Returns the average of the elements in the two dimensional array
	 * @param data the two dimensional array getting the average of
	 * @return the average of the elements in the two dimensional array (total of elements/num of elements)

	 */
	public static double getAverage(double[][] data) {
		int counter=0;
		double total=0;
		double average=0;
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				total+=data[i][j];
				counter++;
			}
		}
		average=total/counter;
		return average;
	}

	/**
	 * Returns the total of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal=0;
		for(int i=0; i<data[row].length; i++) {
			rowTotal+=data[row][i];
		}
		return rowTotal;
	}

	/**
	 * Returns the total of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col the column index to take the total of (0 refers to the first column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double colTotal=0;
		for(int i=0; i<data.length; i++) {
			if(data[i].length-1>=col) {
				colTotal+=data[i][col];
			}
		}
		return colTotal;
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		int index=getHighestInRowIndex(data, row);
		return data[row][index];
	}

	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row  the row index to find the largest element of (0 refers to the first row)
	 * @return the index of the largest element of the row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double max=Double.MIN_VALUE;
		int index=0;
		for(int i=0; i<data[row].length; i++) {
			if (data[row][i]>max) {
				max=data[row][i];
				index=i;
			}
		}
		return index;
	}

	/**
	 * Returns the smallest element of the selected row in the two dimensional array
	 * index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row  the row index to find the smallest element of (0 refers to the first row)
	 * @return the smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		int index=getLowestInRowIndex(data, row);
		return data[row][index];

		//can also call getLowestInRowIndex and use index of that
	}

	/**
	 * Returns the index of the smallest element of the selected row in the two dimensional array 
	 * index 0 refers to the first row.
	 * @param data the two dimensional array
	 * @param row the row index to find the smallest element of (0 refers to the first row)
	 * @return the index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double min= Double.MAX_VALUE;
		int index=0;
		for(int i=0; i<data[row].length; i++) {
			if (data[row][i]<min) {
				min=data[row][i];
				index=i;
			}
		}
		return index;
	}

	/**
	 * Returns the largest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col the column index to find the largest element of (0 refers to the first column)
	 * @return the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {

		int index=getHighestInColumnIndex(data, col);
		return data[index][col];
	}

	/**
	 * Returns index of the largest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col the column index to find the largest element of (0 refers to the first column)
	 * @return the index of the largest element of the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int index=0;
		double max = Double.MIN_VALUE;
		for(int i=0; i<data.length; i++) {
			if(data[i].length-1>=col) {
				if(data[i][col]>max) {
					max=data[i][col];
					index=i;
				}
			}
		}
		return index;
	}


	//		double max=Double.MIN_VALUE;
	//		int index=0;
	//		for(int i=0; i<data.length; i++) {
	//			if(data[i].length>=col) {
	//				if(data[i][col]>max) {
	//					max=data[i][col];
	//					index=i;
	//				}
	//			}
	//		}
	//		return index;


	/**
	 * Returns the smallest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col the column index to find the smallest element of (0 refers to the first column)
	 * @return the smallest element of the column

	 */
	public static double getLowestInColumn(double[][] data, int col) {
		int index=getLowestInColumnIndex(data, col);
		return data[index][col];
	}

	/**
	 * Returns the index of the smallest element of the selected column in the two dimensional array index 0 refers to the first column. 
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col  the column index to find the smallest element of (0 refers to the first column)
	 * @return the index of the smallest element of the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double min=Double.MAX_VALUE;
		int index=0;
		for(int i=0; i<data.length; i++) {
			if(data[i].length-1>=col) {
				if(data[i][col]<min) {
					min=data[i][col];
					index=i;
				}
			}
		}
		return index;
	}

	/**
	 * Returns the largest element in the two dimensional array
	 * @param data the two dimensional array
	 * @return the largest element in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data) {
		double max=Double.MIN_VALUE;
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				if(data[i][j]>max) {
					max=data[i][j];
				}
			}
		}
		return max;
	}

	/**
	 * Returns the smallest element in the two dimensional array
	 * @param data the two dimensional array
	 * @return the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		double min=Double.MAX_VALUE;
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				if(data[i][j]<min) {
					min=data[i][j];
				}
			}
		}
		return min;
	}

}
