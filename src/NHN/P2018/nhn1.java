package NHN.P2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class nhn1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=c; i++) {
			list.add(i);
		}
		while(p-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for(int i=n; i<list.size()-n; i++) {
				int temp = list.get(i);
				list.remove(i);
				list.add(cnt, temp);
				cnt++;
			}
			while(cnt > 2*n) {
				int loop = cnt;
				cnt = 0;
				for(int i=n; i<loop-n; i++) {
					int temp = list.get(i);
					list.remove(i);
					list.add(cnt, temp);
					cnt++;
				}
			}
			
		}
		for(int i=0; i<5; i++) {
			System.out.println(list.get(i));
		}
	}	
}
