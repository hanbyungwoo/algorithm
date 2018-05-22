import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11047 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		
		long arr[] = new long[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = 0;
		long temp = K;
		for(int i=N-1; i>=0; i--) {
			if( temp >= arr[i] ) {
				min += temp/arr[i];
				temp %= arr[i];
			}
			if(temp == 0) {
				break;
			}
		}
		
		System.out.println(min);
		
	}
}
