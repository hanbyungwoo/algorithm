package graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//4 2
//4 2
//3 1
public class A1516 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int num = Integer.parseInt(st.nextToken());
		
		// 위상에 대한 정리
//		List<Integer>[] list = (List<Integer>[]) new List[num+1];
		
		// n번 edge에 연결된 숫자들
		List<Integer>[] val = (List<Integer>[]) new List[num+1];
		
		for(int i=1; i<=num; i++) {
//			list[i] = new ArrayList<Integer>();
			val[i] = new ArrayList<Integer>();
		}
		
		int ind[] = new int[num+1];
		int time[] = new int[num+1];
		int d[] = new int[num+1];
		
		for(int i=1; i<=num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int j=i;
			while(st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				if(a==-1) {
					break;
				}
				if(j==i) {
					time[j] = a;
					j++;
				} else {
//					list[i].add(a);
					val[a].add(i);
					ind[i]++;
				}
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=num; i++) {
			if(ind[i]==0) {
				q.add(i);
			}
			d[i] += time[i];
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			int cur = q.poll();
			for(int i=0; i<val[cur].size(); i++) {
				int next = val[cur].get(i);
				// 이전 점에서 미리 다음 next의 값을...저장하네..?!
				d[next] = Math.max(d[next], d[cur]+time[next]);
				if(--ind[next] == 0) {
					q.add(next);
				}
			}
			
//			for(int i=0; i<size; i++) {
//				int x = q.poll();
//				for(int y : val[x]) {
//					
//					ind[y]--;
//					
//					if(ind[y]==0) {
//						q.add(y);
//					}
//				}
//				for(int y : list[x]) {
////					if(d[x] < d[y] + time[x]) {
////						d[x] = d[y] + time[x];
////					}
//					d[x] += time[y];
//				}
//			}
		}
		
		for(int i=1; i<=num; i++) {
			System.out.println(d[i]);
		}
		
		

	}
}