package eDailyCoding;

import java.util.Arrays;
import java.util.Scanner;

public class A016_배수만들기 {
	static int num, max;
	static int n[];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        num = sc.nextInt();
        n = new int[num];
        max = -1;
        for(int i=0; i<num; i++) {
        	n[i] = sc.nextInt();
        }
        
        Arrays.sort(n);
        
        do {
        	StringBuilder sb = new StringBuilder();
            for (int i=0; i<n.length; i++) {
            	sb.append(n[i]);
            }
            int temp = Integer.parseInt(sb.toString());
            if(temp%300 == 0) {
            	max = Math.max(temp, max);
            }
        } while(next_permutation(n));
        System.out.println(max);
      
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
