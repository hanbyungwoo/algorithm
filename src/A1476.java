import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1476 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int temp_E=1, temp_S=1, temp_M=1;
		int cnt=1;
		for(int i=0; ;i++) {
			if((i-E)%15==0 && (i-S)%28==0 && (i-M)%19==0 ) {
				System.out.println(i);
				break;
			}
		}
//		while(true) {
//			if(temp_E == E && temp_S == S && temp_M == M) {
//				System.out.println(cnt);
//				break;
//			}
//			temp_E++;
//			temp_S++;
//			temp_M++;
//			if(temp_E >= 16) {
//				temp_E = 1;
//			}
//			if(temp_S >= 29) {
//				temp_S = 1;
//			}
//			if(temp_M >= 20) {
//				temp_M = 1;
//			}
//			cnt++;
//			
//		}
	}
}
