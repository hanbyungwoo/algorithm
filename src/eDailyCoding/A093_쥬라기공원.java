package eDailyCoding;

import java.util.Arrays;
import java.util.Scanner;

public class A093_쥬라기공원 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		char n[] = sc.next().toCharArray();
        Arrays.sort(n);
        int ans=0;
        do {
        	boolean isCheck = false;
        	char prev = n[0];
            for (int i=1; i<n.length; i++) {
                if(n[i]==prev) {
                	isCheck = true;
                	break;
                } else {
                	prev = n[i];
                }
            }
            if(!isCheck) {
            	ans++;
            }
            
        } while(next_permutation(n));
        
        System.out.println(ans);
    }
    
    public static boolean next_permutation(char[] a) {
    	
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

        char temp = a[i-1];
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