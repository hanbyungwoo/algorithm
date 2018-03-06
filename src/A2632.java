import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A2632 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sell = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int a_pizza[] = new int[a];
		for(int i=0; i<a; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a_pizza[i] = Integer.parseInt(st.nextToken());
		}
		
		int b_pizza[] = new int[b];
		for(int i=0; i<b; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			b_pizza[i] = Integer.parseInt(st.nextToken());
		}.a.
		
		int a_total[] = new int[(1<<a)];
		int temp = 0;
		ArrayList<Integer> aaa = new ArrayList<Integer>();
		///////////////////////////////////////////////
		// 피자 경우의 수 정리해야함;;
		//https://jongmin92.github.io/2017/10/02/Algorithm/boj-2632/
// 2143번
//		for(int i=0; i<a; i++) {
//			int sum=0;
//			for(int j=i; j<a; j++) {
//				// 1qjs 2번 3번 4번
//				for(int k=i; k<=j; k++) {
//					sum += a_pizza[k];
//				}
//				// list 추가.
//				
//			}
//		}
		for(int i=0; i<a-1; i++) {
			for(int j=i; j<a; j++) {
				int sum=0;
				for(int k=i; k<j; k++) {
					sum += a_pizza[k];
				}
				aaa.add(sum);
			}
		}
		for(int i=a-1; i<a; i++) {
			for(int j=0; j<a; j++) {
				int sum=0;
				for(int k=a-1; k<j+a-1; k++) {
					sum += a_pizza[k];
				}
				aaa.add(sum);
			}
		}
		for(int i=0; i<(1<<a); i++) {
			for(int j=0; j<a; j++) {
				if( (i&(1<<j)) != 0) {
					a_total[temp++] = i;
				}
			}
		}
		
		int b_total[] = new int[(1<<b)];
		temp = 0;
		for(int i=0; i<(1<<b); i++) {
			for(int j=0; j<b; j++) {
				if( (i&(1<<j)) != 0) {
					b_total[temp++] = i;
				}
			}
		}
		
		Arrays.sort(a_total);
		
	}
}
