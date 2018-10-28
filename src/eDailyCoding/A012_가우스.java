package eDailyCoding;

import java.util.Scanner;

public class A012_°¡¿ì½º {
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        System.out.print("{");
        for(int i=a; i<a*2; i++) {
        	if(i==a*2-1) {
        		System.out.print(i);
        	} else {
        		System.out.print(i+", ");
        	}
        }
        System.out.print("}");
    }
    
    
}
