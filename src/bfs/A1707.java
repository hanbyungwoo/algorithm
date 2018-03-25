package bfs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1707

// 이분그래프
//문제
//그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.
//
//그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.
//
//입력
//입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K(2≤K≤5)가 주어진다.
//각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V(1≤V≤20,000)와 간선의 개수 E(1≤E≤200,000)가 빈 칸을 사이에 두고 순서대로 주어진다.
//각 정점에는 1부터 V까지 차례로 번호가 붙어 있다. 이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 각 줄에 인접한 두 정점의 번호가 빈 칸을 사이에 두고 주어진다.
//
//출력
//K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.
// 예제
//2		// 테스트 케이스 수
//3 2	// 정점, 간선
//1 3
//2 3
//4 4	// 정점, 간선
//1 2
//2 3
//3 4
//4 2
// 출력
//YES
//NO
public class A1707 {
	static ArrayList<Integer>[] a;
	static boolean[] c;
	static int[] check;
	static boolean result;
	static int value;
	
	public static void dfs(int x, int color) {
		if(color == 0) {
			color = 1;
		} else {
			color = 0;
		}
		
		check[x] = color;
		for(int y : a[x]) {
			if(check[y] == color) {
				result = false;
				return;
			}
		}
		
		if(c[x]) {
			return;
		}
		c[x] = true;
		
		for(int y : a[x]) {
			if(c[y] == false) {
				
				dfs(y, check[x]);
			} 
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int i=0; i<testcase; i++) {
			int edge = sc.nextInt();
			int vector = sc.nextInt();
			a = (ArrayList<Integer>[]) new ArrayList[edge+1];
			for(int j=1; j<=edge; j++) {
				a[j] = new ArrayList<Integer>();
			}
			for(int j=1; j<=vector; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				a[x].add(y);
				a[y].add(x);
			}
			for(int j=1; j<=edge; j++) {
				Collections.sort(a[j]);
			}
			c = new boolean[edge+1];
			check = new int[edge+1];
			value = 0;
			result = true;
			for(int j=1; j<=edge; j++) {
				check[j] = 2;	// 2로 초기화
			}
			
			
			for(int j=1; j<=edge; j++) {
				if(c[j]==false) {
					dfs(j, 0);
				}
			}
			
			if(result == false) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
			
		}
		
	}

}
