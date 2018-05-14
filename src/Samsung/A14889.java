package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A14889 {
	static int N;
	static int map[][];
	static int ans=Integer.MAX_VALUE;
	static boolean team[];
	public static void main(String args[]) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 인원
		
		
		map = new int[N+1][N+1];
		team = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(ans);
	}
	public static void cal() {
		int a[] = new int[N/2+1];
		int b[] = new int[N/2+1];
		int an = 1;
		int bn = 1;
		for(int i=1; i<=N; i++) {
			if(team[i]) {
				a[an++] = i;
			} else {
				b[bn++] = i;
			}
		}
		int x = find(a);
		int y = find(b);
		int temp = Math.abs(x-y);
		if(temp < ans) {
			ans = temp;
		}
	}
	public static int find(int arr[]) {
		int sum=0;
		for(int i=1; i<=N/2; i++) {
			for(int j=i+1; j<=N/2; j++) {
				sum+=map[arr[i]][arr[j]];
				sum+=map[arr[j]][arr[i]];
			}
		}
		return sum;
	}
	public static void dfs(int len, int index) {
		if(len == N/2) {
			cal();
		} else {
			for(int i=index+1; i<=N; i++) {
				if(team[i] == false) {
					team[i] = true;
					dfs(len+1, i);
				}
			}
			
		}
		team[index] = false;
	}
}

//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class A14889 {
//	static boolean check[] = new boolean[21];
//	static int map[][];
//	static int dx[] = {-1,1,0,0};
//	static int dy[] = {0,0,1,-1};
//	static int min=Integer.MAX_VALUE;
//	static int N;
//	public static void main(String args[]) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		N = Integer.parseInt(st.nextToken());	// 인원
//		
//		
//		map = new int[N+1][N+1];
//		
//		for(int i=1; i<=N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j=1; j<=N; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		dfs(0, 0);
//		System.out.println(min);
//	}
//	
//	public static void dfs(int x, int len) {
//		if(len==N/2) {
//			ability();
//		} else {
//			for(int i=x+1; i<=N; i++) {
//				if(check[i]==false) {
//					check[i]=true;
//					dfs(i, len+1);
//				}
//			}
//		}
//		
//		check[x] = false;
//	}
//	
//	public static void ability() {
//		int a[] = new int[N/2+1];
//		int b[] = new int[N/2+1];
//		int ai=1, bi=1;
//		for(int i=1; i<=N; i++) {
//			if(check[i]) {
//				a[ai++] = i;
//			} else {
//				b[bi++] = i;
//			}
//		}
//		int r1 = cal(a);
//		int r2 = cal(b);
//		int ans = Math.abs(r1-r2);
//		if(min > ans) {
//			min = ans;
//		}
//	}
//	
//	public static int cal(int x[]) {
//		int rst=0;
//		for(int i=1; i<=N/2; i++) {
//			for(int j=i+1; j<=N/2; j++) {
//				rst+=map[x[i]][x[j]];
//				rst+=map[x[j]][x[i]];
//			}
//		}
//		return rst;
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
