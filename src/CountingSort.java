import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
	
	static int count =0;
	
	public static void main(String[] args){	
		
	System.out.println("Here is Quick Sort");
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
		
		int[] arrB = new int[length+1];
		for(int j=0; j<length;j++){
			System.out.print(arr[j]+" ");
		}
		System.out.println("\nThe length is "+length);
		System.out.println("");

		countingSort(arr,arrB,length);
		
		System.out.println("---------------------------------");
		
		//print(arr,count,length);


		
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
	public static void countingSort(int[] A, int[] B, int length){
		int k=length-3;
		int[] C = new int[length+1];
		int cost=0;
		for (int i=0; i<=k;i++){
			C[i] = 0;
		}
		for (int j=0; j<length;j++){
			C[A[j]]=C[A[j]]+1;
		}
		for (int i=1; i<C.length; i++){
			C[i] = C[i]+C[i-1];
		}
		for (int j=length-1; j>=0; j--){
			cost+=1;
			B[C[A[j]]] = A[j];
			C[A[j]]=C[A[j]]-1;
		}
		System.out.println("B length: " + B.length);
		print(B,cost,length);
	}


    public static void print(int[] arr, int cost, int length){
		System.out.println("Here is the Sorted Result." );
		if(length < 65){
			for(int i=1; i<=length;i++){ 
				System.out.print(arr[i]+" ");	
			}
		} else {
			for(int i =51; i<=100;i++){
				System.out.print(arr[i]+" ");
			}
		}
		
		System.out.println("\nHere is the Cost: " + cost);
		System.out.println("Here is the lenghth of the array: " + length);
	}
 }