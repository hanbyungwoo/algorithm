import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A5576 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int w[], k[];
	
		w = new int[10];
		k = new int[10];
		
		for(int i=0; i<20; i++) {
			st = new StringTokenizer(br.readLine());
			if(i<10) {
				w[i] += Integer.parseInt(st.nextToken());
			} else {
				k[i-10] += Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(w);
		Arrays.sort(k);
		int wMax = w[9]+w[8]+w[7];
		int kMax = k[9]+k[8]+k[7];
		System.out.println(wMax + " " + kMax);
		
		
		
		
		
	}
}
