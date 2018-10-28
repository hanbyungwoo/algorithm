package eDailyCoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A009_º¼Ææ¼ýÀÚÀÇ°ö {
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
        	list.add(sc.nextInt());
        }
	    Collections.sort(list);
	    int max = 1;
	    int cnt=0;
	    for(int i=n-1; i>0; i--) {
	    	if(list.get(i) > 0 && cnt < 3) {
	    		max *= list.get(i);
	    		cnt++;
	    	} else {
	    		break;
	    	}
	    }
	    int temp = list.get(0)*list.get(1);
	    int temp2 = list.get(n-1);
	    int x=0;
	    if(temp2 > 0) {
	    	x = temp*temp2;
	    } else {
	    	x = temp;
	    }
	    max = Math.max(x, max);
	    System.out.println(max);
    }
    
}
