package eDailyCoding;

import java.util.Scanner;

public class A011_상용로그구하기 {
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        System.out.format("%.2f",Math.log10(a));
    }
    
}
