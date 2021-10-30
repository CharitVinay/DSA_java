import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ArrayReverse
{
    void reverse(int[] arr, int l, int r)
    {
        int len = arr.length;
        int m = l+(r-l)/2;
        int i=l,j=r;
        if(len%2 == 0)
        {
            while(i<m+1 && m<j)
            {
                int temp = arr[l];
                arr[i] = arr[r];
                arr[j] = temp;
                i++;
                j--;
                l++;
                r--;
            }
        }
        else
        {
            // System.out.println("Is it odd!!");
            while(i<m && m<j)
            {
                int temp = arr[l];
                arr[i] = arr[r];
                arr[j] = temp;
                i++;
                j--;
                l++;
                r--;
            }
        }
    }
    static void printarray(int[] arr)
    {
        int len = arr.length;
        for (int i=0; i<len; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
    public static void main(String args[]) throws IOException 
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

        ArrayReverse ob = new ArrayReverse();
        ob.reverse(arr, 0, arr.length-1);

        System.out.println("Sorted Array:");
        printarray(arr);
    }
}