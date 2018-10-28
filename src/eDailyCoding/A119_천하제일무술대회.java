package eDailyCoding;

import java.util.ArrayList;
import java.util.Scanner;

public class A119_천하제일무술대회 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        ArrayList<team> list = new ArrayList<team>();
        for(int i=0; i<n; i++) {
        	String str = sc.next().toString();
        	int score = sc.nextInt();
        	sb.append(str+" ");
        	list.add(new team(str, score));
        }
        sb.insert(0, "\n");
        while(list.size() != 1) {
        	int size = list.size();
        	if(size%2 == 1) {
        		size--;
        		sb.insert(0, list.get(size).name);
        	}
        	for(int i=size-1; i>0; i=i-2) {
        		if(list.get(i).score < list.get(i-1).score) {
        			list.get(i).score = -1;
        			sb.insert(0, list.get(i-1).name+" ");
        		} else {
        			list.get(i-1).score = -1;
        			sb.insert(0, list.get(i).name+" ");
        		}
        	}
        	list.removeIf(f->f.score<0);
        	if(list.size() != 1) {
        		sb.insert(0, "\n");	
        	}
        	
        }
        
        
        System.out.println(sb.toString());
        
    }
    static class team {
    	String name;
    	int score;
    	public team(String name, int score) {
    		this.name = name;
    		this.score = score;
    	}
    }
    
}
