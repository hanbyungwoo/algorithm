import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//https://www.acmicpc.net/problem/11724

// 연결요소와 관련된 문제

// 문제
// 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

// 입력
//첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
//(1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

//출력
//첫째 줄에 연결 요소의 개수를 출력한다.

//예제 입력 
//6 5	// edge vector
//1 2
//2 5
//5 1
//3 4
//4 6

// 출력
//2

public class A11724 {
	static ArrayList<Integer>[] a;
	static boolean []c;
	static int cnt;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int edge = sc.nextInt();
		int vector = sc.nextInt();
		a = (ArrayList<Integer>[]) new ArrayList[edge+1];
		for(int i=1; i<=edge; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<=vector; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		
		for(int i=1; i<=edge; i++) {
			Collections.sort(a[i]);
		}
		
		c = new boolean[edge+1];
		cnt = 0;
		for(int i=1; i<=edge; i++) {
			if(c[i]==false) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
		
	}
	public static void dfs(int x) {
		if(c[x]) {
			return;
		}
		c[x] = true;
		for(int y : a[x]) {
			if(c[y] == false) {
				dfs(y);
			}
		}
	}
}
