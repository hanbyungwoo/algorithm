import java.util.*;

//https://www.acmicpc.net/problem/1753

//문제
//방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다. 
//
//
//입력
//첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1≤V≤20,000, 1≤E≤300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다.
//둘째 줄에는 시작 정점의 번호 K(1≤K≤V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
//이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.
//  u-(-w-)->v
//출력
//첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.


// 출력때문인거같은데;;;
public class A1753 {
	static ArrayList<Integer>[] a;
	static ArrayList<Integer>[] distance;
	static int[] data;
	static boolean[] c;
	public static void dfs(int x) {
		if(c[x]) {
			return;
		}
		c[x] = true;	// 해당 정점 사용한거
		//System.out.print(x + " ");
		for(int i=1; i<=a[x].size(); i++) {
			if(c[a[x].get(i-1)] == false) {
				if(data[a[x].get(i-1)] > distance[x].get(i-1) + data[x]) {
					data[a[x].get(i-1)] = distance[x].get(i-1) + data[x];
					dfs(i);
				}
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		// 정점의 갯수
		int point = sc.nextInt();
		// 간선의 갯수
		int line = sc.nextInt();
		// 시작점의 정보
		int start = sc.nextInt();
		
		a = (ArrayList<Integer>[])new ArrayList[line+1];
		distance = (ArrayList<Integer>[])new ArrayList[line+1];
		data = new int[point+1];
		for(int i=1; i<=point; i++) {	// 정점의 갯수만큼 배열리스트만들기
			a[i] = new ArrayList<Integer>();
			distance[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<line; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int dis = sc.nextInt();
			a[u].add(v);
			//a[v].add(u);
			distance[u].add(dis);
		}
		for(int i=1; i<data.length; i++) {
			data[i] = 999;
		}
//		for(int i=1; i<=point; i++) {
//			Collections.sort(a[i]);
//		}
		c = new boolean[point+1];
		data[start] = 0;
		dfs(start);
//		System.out.println(data[start]);
		for(int i=1; i<data.length; i++) {
			if(data[i] == 999) {
				System.out.println("INF");
			} else {
				System.out.println(data[i]);
			}
		}
		System.out.println();
		
	}
	
	
}