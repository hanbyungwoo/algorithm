package eDailyCoding;

import java.util.Scanner;

public class A020_다양한진법 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        System.out.println("2 " + Integer.toBinaryString(num));
        System.out.println("8 " + Integer.toOctalString(num));
        System.out.println("16 " + Integer.toHexString(num).toUpperCase());
    }
}
