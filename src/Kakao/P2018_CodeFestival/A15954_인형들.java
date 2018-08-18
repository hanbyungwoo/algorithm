package Kakao.P2018_CodeFestival;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A15954_인형들 {
	static int n, k;
	static double min;
	static int arr[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		min = Integer.MAX_VALUE;
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// k개씩 묶었을 때 나올 수 있는 숫자
		for(int z=k; z<=n; z++) {
			
			for(int i=0; i<n-z+1; i++) {
				double avg=0;
				double bunsan=0;
				// 연속된 k개
				for(int j=i; j<i+z; j++) {
					avg += arr[j];
				}
				avg /= z;
				
				// 분산 구하기
				for(int j=i; j<i+z; j++) {
					bunsan += Math.pow((arr[j]-avg), 2);
				}
				bunsan /= z;
				
				// 표준편차 구하기
				if(min > Math.sqrt(bunsan)) {
					min = Math.sqrt(bunsan);
				}
			}	
		}
		
		
		System.out.println(min);
	}
}