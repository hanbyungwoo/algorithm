package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A13458_시험감독 {
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 강의실 갯수
		int peo[] = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			peo[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int main = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		
		long cnt=0;
		for(int i=0; i<N; i++) {
			peo[i] -= main;
			cnt++;
			if(peo[i] > 0) {
				cnt+=peo[i]/sub;
				if(peo[i]%sub > 0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}














