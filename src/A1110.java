import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1110 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int cnt = 1;
		int temp = n;
		while(true) {
			int ten = temp/10;
			int one = temp%10;
			
			int newValue = ten + one;
			newValue %= 10; 
			
			newValue += one*10;
			temp = newValue;
			if(newValue == n) {
				break;
			} else {
				cnt++;
			}
			
		}
		System.out.println(cnt);
		
	}
	
}
