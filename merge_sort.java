/*Pooja Ravi
1001578517*/
//package sorting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class merge_sort {

	public static int[] unsorted_array;
	public static void merge(int p,int q, int r) {
		// TODO Auto-generated constructor stub
		int n1,n2,i1,j1,k1; //indices of the subarrays
		n1=q-p+1;//size of left subarray
		n2=r-q; //size of right subarray
		int L[]=new int[n1+1]; //temporary  left subarray
		int R[]=new int[n2+1]; //temporary  right subarray
		for(i1=0;i1<n1;i1++) {
			L[i1]=unsorted_array[p+i1]; //array values copied to L[]
		}
		for (j1=0 ;j1<n2;j1++) {
			R[j1] = unsorted_array[q+j1+1];//array values copied to R[]
		}
		L[n1]=Integer.MAX_VALUE;//last value of left array to infinite
		R[n2]=Integer.MAX_VALUE;//last value of left array to infinite
		i1=0;
		j1=0;
	
		k1=p;
		while (j1 < n2 && i1 <n1) 
	    { 
	        if (L[i1] <= R[j1]) 
	        { 
	            unsorted_array[k1] = L[i1];  
	            i1++; 
	        } 
	        else
	        { 
	        	 unsorted_array[k1] = R[j1]; 
	            j1++; 
	        } 
	        k1++; 
	    }
		
		while(i1<n1) {
			unsorted_array[k1]=L[i1]; //copy rest of the elements of R[]
			i1++;
			k1++;
		}
		while(j1<n2) {
			unsorted_array[k1]=R[j1];//copy rest of the elements of L[]
			j1++;
			k1++;
		}
	
		
	}//sorting function
	public static void merge_sort(int p, int r) {
	
		if(p<r) {
			int q=(p+r)/2;
			//function to split the array to subarray
			merge_sort(p,q);
			merge_sort(q+1, r);
			merge( p, q, r);
		}
		
	}
		public static void main(String[] args) {
			try {
				BufferedReader input_client = new BufferedReader (new InputStreamReader(System.in))	;
				System.out.println("Enter the size of array : "); //input array size
				int array_size=Integer.parseInt(input_client.readLine());
				System.out.println("Enter the "+array_size+" integer for array ");
				unsorted_array=new int[array_size];
				for(int i =0;i<array_size;i++) {// array for the input
					unsorted_array[i]=Integer.parseInt(input_client.readLine());
				}
				long start_time = System.nanoTime();//to calculate the start time in nanoseconds
				merge_sort(0, array_size-1);
				long end_time = System.nanoTime();//to calculate the end time in nanoseconds
				System.out.print("Sorted Array");
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

	}
