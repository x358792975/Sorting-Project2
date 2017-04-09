import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BucketSort {
	
	static int count =0;
	static int cost=0;
	
	public static void main(String[] args){	
		
	System.out.println("Here is Bucket Sort");
	System.out.println("****************************");
	
	for(int i=7; i<8;i++){
		int[] arr = new int[1000] ;
		int length = 0;
		String filename = "";	
	filename = "Num"+Integer.toString((int)(Math.pow(2,i)))+".txt";
	//System.out.println("The file name is: " +filename);
	try {
		Scanner scanner = new Scanner(new File(filename));
		while (scanner.hasNextInt()) { 
			arr[length] = scanner.nextInt();
			length++;
			}
		System.out.println("\nHere is oringinal array.");
		
		for(int j=0; j<length;j++){
			System.out.print(arr[j]+" ");
		}
		System.out.println("\nThe length is "+length);
		System.out.println("");

		bucketSort(arr,length);
		
		System.out.println("---------------------------------");
		
		print(arr,cost,length);


		
	}catch (FileNotFoundException e){
		e.printStackTrace();
		System.out.print("File can't be found! ");
	}
	catch (IOException e) {
		e.printStackTrace();
		System.out.print("Faild to read the file!");
	}	
	}
}
	public static void bucketSort(int[] A,int length){
		int max = A[0];
	
		
		for(int i=0; i<length;i++){
			if(max <= A[i])
				max=A[i];
		}
		
		int[] bucket = new int[max+1];	
		
		for(int i =0; i<bucket.length; i++){
			bucket[i] = 0;
		}
		for (int i =0; i<length; i++){
			bucket[A[i]]++;
		}
		int output=0;
		for (int i=0; i<bucket.length; i++){
			cost++;
			for(int j=0;j<bucket[i];j++){
				cost++;
				A[output++]=i;
			}
		}
		
	}


    public static void print(int[] arr, int cost, int length){
		System.out.println("Here is the Sorted Result." );
		if(length < 65){
			for(int i=0; i<length;i++){ 
				System.out.print(arr[i]+" ");	
			}
		} else {
			for(int i =50; i<100;i++){
				System.out.print(arr[i]+" ");
			}
		}
		
		System.out.println("\nHere is the Cost: " + cost);
		System.out.println("Here is the lenghth of the array: " + length);
	}
 }
