package eDailyCoding;

import java.util.Scanner;

public class A024_Ä£Ã´¼ö {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int arr[] = new int[num];
        int min=999999;
        for(int i=0; i<num; i++) {
        	arr[i] = sc.nextInt();
        	min = Math.min(min, arr[i]);
        }
        
        for(int i=2; i<=min; i++) {
        	int prev = arr[0]%i;
        	boolean isTrue = false;
        	for(int j=1; j<num; j++) {
        		if(arr[j]%i != prev) {
        			isTrue = true;
        			break;
        		}
        	}
        	if(!isTrue) {
        		System.out.print(i+" ");
        	}
        }
    }
    
}
