package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// http://stack07142.tistory.com/tag/%EB%B0%B1%EC%A4%80%205214
public class A5214 {
	
	static final int INF = 10000000;

    static int[] dist = new int[101005];
    static boolean[] discovered = new boolean[101005];

    static {

        Arrays.fill(dist, INF);
    }
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> edge = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N+M; i++) {
			edge.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int dummy=i+N;
			for(int j=1; j<=K; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				edge.get(dummy).add(temp);
				edge.get(temp).add(dummy);
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(1);
		dist[1] = 1;
		discovered[1] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			if(x == N) {
				break;
			}
			
			for(int y : edge.get(x)) {
				if(!discovered[y] && dist[y] > dist[x] + 1) {
					q.add(y);
					dist[y] = dist[x] + 1;
					discovered[y] = true;
				}
			}
		}
		
		System.out.println(dist[N] >= INF? -1 : (dist[N]+1)/2);
	}
}