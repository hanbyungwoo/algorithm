package eDailyCoding;

import java.util.Scanner;

public class A014_�Ҽ��Ǻ� {
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
        	// �Ҽ�
        	System.out.println(1);
        }
    }
    
    
}
