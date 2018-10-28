package eDailyCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A002_반찬투정 {
	static boolean isPick[];
	static int n;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		isPick = new boolean[n];
		
		for(int i=0; i<n; i++) {
			if(!isPick[i]) {
				dfs(i, 0);
			}
		}
	}
	
	public static void dfs(int index, int depth) {
		if(depth == n) {
			for(int i=0; i<n; i++) {
				if(isPick[i]) {
					System.out.print("0");
				} else {
					System.out.print("1");
				}
			}
			System.out.println();
		}	
		
		for(int i=index; i<n; i++) {
			if(!isPick[i]) {
				isPick[i] = true;
				dfs(i+1, depth+1);
				isPick[i] = false;
				dfs(i+1, depth+1);
			}
		}
	}
}
