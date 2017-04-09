import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
	
	static int count =0;
	static int cost =0;
	
	public static void main(String[] args){	
		
	System.out.println("Here is Radix Sort");
	System.out.println("****************************");
	
	for(int i=4; i<5;i++){
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

		radixSort(arr,length);
		
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
	public static void radixSort(int[] A, int length){
		//int cost=0;
		for (int i=1; i<=1000000000;i *=10){
			cost+=1;
			A=countingSort(A,i,length);
		}
		print(A,cost,length);
	}

	public static int[] countingSort(int[] A, int place, int length){
		int[] B = new int[length];
		
		int[] count = new int[10];

        for(int i=0; i < length; i++){
            int digit = getDigit(A[i], place);
            count[digit] += 1;
        }

        for(int i=1; i < count.length; i++){
            count[i] += count[i-1];
        }

        for(int i = length-1; i >= 0; i--){
        	cost+=1;
            int digit = getDigit(A[i], place);
            B[count[digit]-1] = A[i];
            count[digit]--;
        }

        return B;
	
	}
    public static int getDigit(int value, int digitPlace){
        return ((value/digitPlace ) % 10);
    }
    public static void print(int[] arr, int cost, int length){
		System.out.println("Here is the Sorted Result." );
		if(length < 65){
			for(int i=0; i<length;i++){ 
				System.out.print(arr[i]+" ");	
			}
		} else {
			for(int i =50; i<=100;i++){
				System.out.print(arr[i]+" ");
			}
		}
		
		System.out.println("\nHere is the Cost: " + cost);
		System.out.println("Here is the lenghth of the array: " + length);
	}
 }