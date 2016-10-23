import java.util.*;
import java.io.*;
import java.lang.Math;

public class BinarySearch {
	
	//initialize variables
	Scanner input = new Scanner(System.in);
	int[] array;
	int arrSize = 0 ;
	int userInput = 0;

	public void BinarySearchOperations(){

		//checking if input is valid for array size
		do
		{
			try
			{

				System.out.println("Enter the size of the array (integer, positive only)");
				arrSize = input.nextInt();
			}
			catch(InputMismatchException e){

				System.out.println("Invalid input");
			}			
			//clear the input's buffer
			input.nextLine();

		} while(arrSize<=0);

				array = new int[arrSize];

		System.out.println("Enter the elements in integer format");

		//checking if input is valid for array elements
		for(int i=0;i<arrSize;i++)
		{
			do
			{
				try
				{

					array[i] = input.nextInt();
				}	
				catch(InputMismatchException e){

				System.out.println("Invalid input. A zero will add up to the list");
				}	
				//clear the input's buffer
				input.nextLine();

			} while(array[i] != (int)array[i]);
		}		
		
		//sort the array in asceding order.. Crusial!!
		Arrays.sort(array);

		//print the sorted array
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}

		System.out.println("");


		do
		{
			try
			{
				//the array's element the algorithm is looking for
				System.out.println("Enter the element you want to search for");
				userInput = input.nextInt();
			} 
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input. A zero will be placed as user's input");
			}
			//clear the input's buffer
			input.nextLine();

		} while(userInput != (int)userInput);	


		/*
		*	Execute Binary Search
		*/

		//create the boundaries for the array
		int left = 0;
		int right = (array.length)-1;
		//round up, in case of even number of elements in the array
		int middle = Math.round((left+right)/2);
		
		//for debugging 
		//System.out.println("First left, middle and right:" + left + "," + middle + "," + right);

		//check if input exceeds the array's size
		if(userInput < array[left] || userInput > array[(array.length)-1]){

			System.out.println("The element was not found");

		}
		else{

			while(left<right)
			{	
				//check if the element was found by the algorithm
				if(userInput == array[middle]){
					System.out.println("Found in place number " + (middle+1) + " of the array!");
					break;
				}
				//check if the element was found by the algorithm in the right boundary
				else if(userInput == array[right]){
					System.out.println("Found in place number " + (right+1) + " of the array!");
					break; 
				}
				/*
				 * change the boundaries of the algorithm, dependently of the requested element's size
				*/
				else if(userInput < array[middle]){
					right = middle;
					middle = Math.round((left+right)/2);
				}
				else if(userInput > array[middle]){
					left = middle;
					middle = Math.round((left+right)/2);
				}

			//for debugging 
			//System.out.println("left, middle and right:" + left + "," + middle + "," + right);
			
			}
		}

	} 



    public static void main(String []args)
    {
    	System.out.println("");
    	System.out.println("--- BINARY SEARCH ALGORITHM ---");

    	//create an instance of a class and call BinarySearchOperations method
    	BinarySearch o = new BinarySearch();
    	o.BinarySearchOperations();
    }
}
