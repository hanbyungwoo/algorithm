package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1525 {
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=3;
		int start=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 0) {
					temp = 9;
				}
				start = start*10+temp;
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		HashMap<Integer, Integer> d = new HashMap<Integer, Integer>();
		d.put(start, 0);
		q.add(start);
		while(!q.isEmpty()) {
			int now_num = q.poll();
			String now = Integer.toString(now_num);
			int z = now.indexOf('9');
			int x = z/3;
			int y = z%3;
			for(int k=0; k<4; k++) {
				int nx=x+dx[k];
				int ny=y+dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    StringBuilder next = new StringBuilder(now);
                    // swap
                    char temp = next.charAt(x*3+y);
                    next.setCharAt(x*3+y, next.charAt(nx*3+ny));
                    next.setCharAt(nx*3+ny, temp);
                    
                    int num = Integer.parseInt(next.toString());
                    if (!d.containsKey(num)) {
                        d.put(num, d.get(now_num)+1);
                        q.add(num);
                    }
                }
			}
		}
		
		 if (d.containsKey(123456789)) {
            System.out.println(d.get(123456789));
        } else {
            System.out.println("-1");
        }
	 
	}
}
