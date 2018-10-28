package eDailyCoding;

import java.util.Scanner;

public class A013_а╤гу {
	static boolean visited[];
	static int a, b, ans;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        a = sc.nextInt();
        b = sc.nextInt();
        visited = new boolean[a];
        for(int i=0; i<a; i++) {
        	visited[i] = true;
        	dfs(i, 1);
        	visited[i] = false;
        }
        
        System.out.println(ans);
    }
    
    public static void dfs(int index, int depth) {
    	if(depth == b) {
    		ans++;
    		return;
    	}
    	for(int i=index+1; i<a; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			dfs(i, depth+1);
    			visited[i] = false;
    		}
    	}
    }
    
}
