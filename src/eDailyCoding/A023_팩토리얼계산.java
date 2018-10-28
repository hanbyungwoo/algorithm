package eDailyCoding;

import java.util.Scanner;

public class A023_팩토리얼계산 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int mul = 1;
        for(int i=num; i>0; i--) {
        	mul *= i;
        }
        System.out.println(mul);
    }
    
}
