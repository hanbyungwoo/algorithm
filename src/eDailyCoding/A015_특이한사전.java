package eDailyCoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class A015_특이한사전 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Dict> list = new ArrayList<Dict>();
        int num = sc.nextInt();
        HashSet<String> set = new HashSet<String>();
        for(int i=0; i<num; i++) {
        	String str = sc.next().toString();
        	if(!set.contains(str)) {
        		list.add(new Dict(str, str.length()));
        		set.add(str);
        	}
        }
        
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
        	System.out.println(list.get(i).str);
        }
      
    }
    
    static class Dict implements Comparable<Dict> {
    	int size;
    	String str;
    	public Dict(String str, int size) {
    		this.size = size;
    		this.str = str;
    	}
		@Override
		public int compareTo(Dict o) {
			if(this.size < o.size) {
				return -1;
			} else if(this.size == o.size) {
				if(this.str.compareTo(o.str)<0) {
					return -1;
				} else {
					return 1;
				}
			}
			return 1;
		}
    }
}
