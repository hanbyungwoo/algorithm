package eDailyCoding;

import java.util.Arrays;
import java.util.Scanner;

public class A018_난이도조절 {
	static int num, max, min;
	static int n[];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        num = sc.nextInt();
        n = new int[num];
        min = Integer.MAX_VALUE;
        max = Integer.MAX_VALUE;
        for(int i=0; i<num; i++) {
        	n[i] = sc.nextInt();
        }
        
        Arrays.sort(n);
        
        do {
        	int diff = Math.abs(n[0]-n[num-1]);
        	int diff_max = diff;
            for (int i=1; i<n.length; i++) {
            	int temp = Math.abs(n[i-1]-n[i]);
            	diff_max = Math.max(temp, diff_max);
            	diff += temp;
            }
            if(min >= diff) {
            	min = diff;
            	max = Math.min(diff_max, max);
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
