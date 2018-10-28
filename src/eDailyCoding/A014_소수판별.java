package eDailyCoding;

import java.util.Scanner;

public class A014_소수판별 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        boolean arr[] = new boolean[num+1];
        
        for(int i=2; i<=num; i++) {
        	for(int j=i*i; j<=num; j=j+i) {
        		if(!arr[j]) {
        			arr[j] = true;
        		}
        	}
        }
        
        if(arr[num]) {
        	System.out.println(0);
        } else {
        	// 소수
        	System.out.println(1);
        }
    }
    
    
}
