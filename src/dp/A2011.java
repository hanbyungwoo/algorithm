package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2011 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char arr[] = st.nextToken().toString().toCharArray();
		int mod = 1000000;
		int d[] = new int[arr.length+1];
		d[0] = 1;
		for(int i=1; i<=arr.length; i++) {
			int x = arr[i-1]-'0';
			if(1<=x && x<=9) {
				d[i] = (d[i]+d[i-1])%mod;
			}
			if(i==1) continue;
			if(arr[i-2] == '0') continue;
			x = (arr[i-2]-'0')*10+(arr[i-1]-'0');
			if(10<=x && x<=26) {
				d[i] = (d[i]+d[i-2])%mod;
			}
		}
		
		System.out.println(d[arr.length]);
	}
}
