/*Pooja Ravi
1001578517*/
//package sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class quick_sort {
	public static int unsorted_array[];
	
	public static int Partition(int p, int r) {
		//In this function, the last element is selected as pivot and smaller 
		//values compared to pivot are kept at the left of pivot and the larger ones on the right side
		int pivot,i1,j1,temp,temp1; //initial indices
		pivot=unsorted_array[r]; //assign last element as pivot
		i1 = p-1;
		for(j1=p;j1<r;j1++) {
			if(unsorted_array[j1]<=pivot) {
				i1=i1+1;
				temp= unsorted_array[i1];
				unsorted_array[i1]=unsorted_array[j1];
				unsorted_array[j1]=temp;
			}
		}
		temp1= unsorted_array[i1+1];
		unsorted_array[i1+1]=unsorted_array[r];
		unsorted_array[r]=temp1;
		return i1+1;
	}

	public static void main(String[] args) {
		try {
			BufferedReader input_client = new BufferedReader (new InputStreamReader(System.in))	;
			System.out.println("Enter the size of array : ");//input array size

			int array_size=Integer.parseInt(input_client.readLine());
			System.out.println("Enter the "+array_size+" integer for array ");
			unsorted_array =new int[array_size]; //create input array

			for(int i =0;i<array_size;i++) {
				unsorted_array[i]=Integer.parseInt(input_client.readLine());
			}
			long start_time = System.nanoTime();//to calculate the start time in nanoseconds
			quicksort( 0, array_size-1);
			long end_time = System.nanoTime();//to calculate the end time in nanoseconds
			System.out.print("Sorted Array ");
			for(int i =0;i<array_size;i++) {
				System.out.print(" > "+unsorted_array[i]);
			}
			//to calculate the execution time in nanoseconds
			System.out.println("\nExecution Time: "+(end_time-start_time)+ " nanoseconds");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}
	//sorting function
	public static void quicksort(int p,int r) {
		if(p<r) {
			int q=Partition(p,r);
			//sorting before and after partitioning
			quicksort(p,q-1);
			quicksort(q+1,r);

		}

	}


}
