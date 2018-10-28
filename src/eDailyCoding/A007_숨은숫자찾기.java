package eDailyCoding;

import java.util.Scanner;

public class A007_숨은숫자찾기 {
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        boolean number[] = new boolean[10];
        for(int i=1; i<=n; i++) {
        	int num = sc.nextInt();
        	if(num == 0) {
        		number[0] = true;
        	}
        	while(num!=0) {
        		int mok = num % 10;
        		number[mok] = true;
        		num = num / 10;
        	}
        }
        for(int i=0; i<10; i++) {
        	if(!number[i]) {
        		System.out.print(i+" ");
        	}
        }
       
    }
    
}
