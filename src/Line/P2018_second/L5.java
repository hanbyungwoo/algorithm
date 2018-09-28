package Line.P2018_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 입력형식
//5
//0 4 5
//3 4 20
//6 6 3
//8 5 35
//10 4 12

// 출력
//55
//3 4
//8 5

public class L5 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> start = new ArrayList<Integer>();
		ArrayList<data> val = new ArrayList<data>();
		int pre[] = new int[201];
		int cost[] = new int[201];
		Arrays.fill(pre, -1);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int I = Integer.parseInt(st.nextToken());
			
			val.add(new data(M, M+D, I));
			cost[M] = I;
		}
		
		for(int i=0; i<val.size(); i++) {
			for(int j=i+1; j<val.size(); j++) {
				if(val.get(i).end < val.get(j).start) {
					if(val.get(j).cost + cost[val.get(i).start] > cost[val.get(j).start]) {
//						pre[val.get(j).start] = val.get(i).start;	// 경로
						pre[val.get(j).start] = i;
						cost[val.get(j).start] = val.get(j).cost + cost[val.get(i).start];	// 비용
					}
				}
			}
		}
		
		int max = 0;
		int c=0;
		for(int i=0; i<201; i++) {
			if(cost[i] > max) {
				max = cost[i];
				c = i;
			}
		}
		
		
		int ff = c;
		while(cost[ff] > -1) {
			int pp = pre[ff];
			start.add(ff);
			if(pp == -1) {
				break;
			}
			ff = val.get(pp).start;
			
		}
		
			
		System.out.println(cost[c]);
		Collections.sort(start);
		for(int i=0; i<start.size(); i++) {
			for(int j=0; j<val.size(); j++) {
				if(val.get(j).start == start.get(i)) {
					// 시작일이같음
					System.out.println(val.get(j).start+" "+(val.get(j).end-val.get(j).start));
					break;
				}
			}
		}
		
    }
	
}

class data {
	int start;
	int end;
	int cost;
	public data(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}
