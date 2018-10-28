package eDailyCoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A010_완전제곱수 {
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i=1; i<b; i++) {
        	if(i*i>=a) {
        		if(i*i>b) {
        			break;
        		}
        		System.out.print(i*i+" ");
        	}
        }
    }
    
}
