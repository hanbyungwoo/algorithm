package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1018 {
	static int caseA[][];
	static int caseB[][];
	static int map[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		caseA = new int[8][8];
		caseB = new int[8][8];
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if((i+j)%2==0) {
					caseA[i][j] = 1;
					caseB[i][j] = 2;
				} else {
					caseA[i][j] = 2;
					caseB[i][j] = 1;
				}
			}
		}
		
		map = new int [M][N];
		// W -> 1 / B -> 2
		for(int i=0; i<M; i++) {
			char temp[] = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				if(temp[j]=='W') {
					map[i][j] = 1;
				} else {
					map[i][j] = 2;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<M-7; i++) {
			for(int j=0; j<N-7; j++) {
				int n = cal(i, j);
				if(n < min) {
					min = n;
				}
			}
		}
		System.out.println(min);
	}
	
	public static int cal(int x, int y) {
		int a=0, b=0;
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				if(map[i][j] != caseA[i-x][j-y]) {
					a++;
				}
				if(map[i][j] != caseB[i-x][j-y]) {
					b++;
				}
			}
		}
		return (a > b) ? b : a;
	}
}
