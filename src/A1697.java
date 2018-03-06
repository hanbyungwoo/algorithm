import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1697 {
	public static void main(String args[]) throws IOException {
		int arrow[] = {-1, 1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(first);
		boolean check[] = new boolean[100001];
		int dist[] = new int[100001];
		int temp=0;
		if(first == second) {
			System.out.println(0);
			return;
		}
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=0; i<3; i++) {
				if(i < 2) {
					temp = x + arrow[i];
				} else {
					temp = x * 2;	
				}
				
				if(temp < 200001 && temp >= 0) {
					if(check[temp] == false) {
						q.add(temp);
						check[temp] = true;
						dist[temp] = dist[x] + 1;
					}
				}
				if(temp == second) {
					System.out.println(dist[temp]);
					return;
				}
			}
			
			
			
			
		}
	}
}
