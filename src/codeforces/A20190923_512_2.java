package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A20190923_512_2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		// (0, n), (d, 0), (n, n-d), (n-d, n)

		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 4점에 대하여 각각의 기울기 4개 안에 포함되도록 한 것임.
			if(x+y<d || x+y>n*2-d) {
				System.out.println("NO");
				continue;
			}
			if(Math.abs(x-y)>d) {
				System.out.println("NO");
				continue;
			}
			System.out.println("YES");
		}
	}
}


