package eDailyCoding;

import java.util.Scanner;

public class A019_하노이타워 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        hanoi(num, 'A', 'B', 'C');
    }
    public static void hanoi(int num, char from, char by, char to) {
    	if(num==1) {
    		System.out.println("원판 1 : " + from + "에서 " + to + "로");
    	} else {
    		hanoi(num-1, from, to, by);
    		System.out.println("원판 "+num+" : " + from + "에서 " + to + "로");
    		hanoi(num-1, by, from, to);
    	}
    }
}
