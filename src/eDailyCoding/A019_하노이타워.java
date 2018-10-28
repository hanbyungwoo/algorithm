package eDailyCoding;

import java.util.Scanner;

public class A019_�ϳ���Ÿ�� {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        hanoi(num, 'A', 'B', 'C');
    }
    public static void hanoi(int num, char from, char by, char to) {
    	if(num==1) {
    		System.out.println("���� 1 : " + from + "���� " + to + "��");
    	} else {
    		hanoi(num-1, from, to, by);
    		System.out.println("���� "+num+" : " + from + "���� " + to + "��");
    		hanoi(num-1, by, from, to);
    	}
    }
}
