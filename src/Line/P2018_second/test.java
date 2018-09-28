package Line.P2018_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// test 2¹ø
		int t = Integer.parseInt(st.nextToken());
		int sum = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<t; i++) {
			sum += Integer.parseInt(st.nextToken());
		}
		System.out.println(sum);
		
		// test 1¹ø
		/*int t = Integer.parseInt(st.nextToken());
		int max = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<t; i++) {
			max = Math.max(max, Integer.parseInt(st.nextToken()));
		}
		System.out.println(max);*/
	}
}
