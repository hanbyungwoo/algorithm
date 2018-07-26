import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/7453
public class A7453 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int line = Integer.parseInt(st.nextToken());
		ArrayList<Integer> a, b, c, d;
		a = new ArrayList<Integer>();
		b = new ArrayList<Integer>();
		c = new ArrayList<Integer>();
		d = new ArrayList<Integer>();
		
		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a.add(Integer.parseInt(st.nextToken()));
			b.add(Integer.parseInt(st.nextToken()));
			c.add(Integer.parseInt(st.nextToken()));
			d.add(Integer.parseInt(st.nextToken()));
		}
		
		ArrayList<Integer> first, second;
		first = new ArrayList<Integer>();
		second = new ArrayList<Integer>();
		
		for(int i=0; i<line; i++) {
			for(int j=0; j<line; j++) {
				first.add(a.get(i)+b.get(j));
				second.add(c.get(i)+d.get(j));
			}
		}
		Collections.sort(first);
		Collections.sort(second);
		long ans = 0;
		for(int i=0; i<first.size(); i++) {
			for(int j=0; j<second.size(); j++) {
				if(first.get(i) == second.get(j)) {
					System.out.println(i + ", " + j);
				}
			}
		}
//		for(int num : first) {
//			for(int num2 : second) {
//				if(num2-num==0) {
//					ans++;
//				}
//			}
//		}
//		
//		System.out.println(ans);
	}
}
