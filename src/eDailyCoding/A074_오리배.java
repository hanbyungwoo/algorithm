package eDailyCoding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A074_¿À¸®¹è {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        
        int v[] = new int[n];
        for(int i=0; i<n; i++) {
        	v[i] = sc.nextInt();
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        int max = -1;
        int seq = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	if(seq == n) {
        		break;
        	}
        	for(int i=0; i<size; i++) {
        		int x = q.poll();
        		int big = x + v[seq];
        		int small = x - v[seq];
        		if(seq+1 == n && big <= m) {
        			max = Math.max(max, big);
        		}
        		if(big <= m) {
        			q.add(big);
        		}
        		if(small >= 0) {
        			q.add(small);
        		}
        		
        	}
        	seq++;
        }
        
        System.out.println(max);
        
    }
	
}