import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		boolean val[] = new boolean[num+1];
		
		for(int i=1; i<=num; i++) {
			if(num%i == 0) {
				System.out.print(i+ " ");
			}
		}
//		for(int i=2; i<=num; i++) {
//			for(int j=i*i; j<=num; j=j+i) {
//				if(val[j] == false) {
//					val[j] = true;
//				}
//			}
//		}
//		for(int i=1; i<=num; i++) {
//			if(val[i]==false)
//				System.out.print(i+ " ");
//		}
		
		
	}
}
