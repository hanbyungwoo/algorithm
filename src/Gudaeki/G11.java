package Gudaeki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G11 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int sum=0;
		for(int i=1; i<=N; i++) {
			if(N%i==0) {
				sum += i;
			}
		}
		
		System.out.println(sum*5-24);
	}
}

/// x*5-24