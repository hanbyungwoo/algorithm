package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A9019 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int testCase = Integer.parseInt(st.nextToken());
		
		while(testCase-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			int dist[] = new int[10001];	// value
			int from[] = new int[10001];	// ÀÌÀü °ª
			char how[] = new char[10001];	// D S L R
			boolean check[] = new boolean[10001];	// true false
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(first);
			
			while(!q.isEmpty()) {
				int now = q.poll();
				check[now] = true;
				int next=0;
				// D Case
				next = (now*2)%10000;
				if(check[next]==false) {
					dist[next] = dist[now] + 1;
					check[next] = true;
					from[next] = now;
					how[next] = 'D';
					q.add(next);
				}
				// S Case
				next = (now-1) == -1 ? 9999 : now-1;
				if(check[next]==false) {
					dist[next] = dist[now] + 1;
					check[next] = true;
					from[next] = now;
					how[next] = 'S';
					q.add(next);
				}
				// L Case
				next = (now%1000)*10+(now/1000);
				if(check[next]==false) {
					dist[next] = dist[now] + 1;
					check[next] = true;
					how[next] = 'L';
					from[next] = now;
					q.add(next);
				}
				// R Case
				next = (now/10)+(now%10)*1000;
				if(check[next]==false) {
					dist[next] = dist[now] + 1;
					check[next] = true;
					how[next] = 'R';
					from[next] = now;
					q.add(next);
				}
				
			}
			StringBuilder sb = new StringBuilder();
			while(second != first) {
				sb.append(how[second]);
				second = from[second];
			}
			System.out.println(sb.reverse());
		}
	}
}
