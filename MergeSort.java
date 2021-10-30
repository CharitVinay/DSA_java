import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MergeSort
{
    void merge(int arr[], int l, int m, int r)
    {
        int[] L = Arrays.copyOfRange(arr, l, m+1);
        int[] R = Arrays.copyOfRange(arr, m+1, r+1);

        int i=0, j=0;
        int k = l;
        // checking the two numbers and swapping the least number first
        while(i<L.length && j<R.length)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        //copying the remaining elements of the L[] array
        while(i<L.length)
        {
            arr[k] = L[i];
            k++;
            i++;
        }
        // copying the remaining elements of the R[] array
        while(j<R.length)
        {
            arr[k] = R[j];
            k++;
            j++;
        }
    }

    void sort(int arr[], int l, int r)
    {
        if(l<r)
        {
            int m = l+(r-l)/2;
            //sort the left side of the array
            sort(arr, l, m);
            // sort the right side of the array
            sort(arr, m+1, r);
            // It merge the two sorted arrays
            merge(arr, l, m, r);
        }
    }

    static void printarray(int arr[])
    {
        int len =  arr.length;
        for(int i=0; i<len; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

    //main function

    public static void main(String[] args) throws IOException
    {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        String[] strNums;

        strNums = bi.readLine().split(" ");

        for (int i=0; i<strNums.length; i++)
        {
            arr[i] = Integer.parseInt(strNums[i]);
        }

        System.out.println("Given Array:");
        printarray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("Sorted Array:");
        printarray(arr);

        // Input: 5
        // Input: 5 10 3 32 48

        // Output: 3 5 10 32 48

    }
}