package eDailyCoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A021_학생들의등수 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<num; i++) {
        	int temp =sc.nextInt();
        	list.add(temp);
        	q.add(temp);
        }
        
        Collections.sort(list);
        Collections.reverse(list);
        
        while(!q.isEmpty()) {
        	int temp = q.poll();
        	System.out.println(temp + " " + (list.indexOf(temp)+1));
        }
        
    }
    
}
