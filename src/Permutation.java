import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
    public static void main(String args[]) {
        int []n = {4,2,3,1,0};
        Arrays.sort(n);
        do {
            for (int i=0; i<n.length; i++) {
                System.out.print(n[i] + " ");
            }
            System.out.println();
        } while(next_permutation(n));
    }
    
    public static boolean next_permutation(int[] a) {
    	
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        // 마지막 순열
        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}