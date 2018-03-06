import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1182 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		String[] sArr = br.readLine().trim().split(" ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int number[] = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		// ������ ����
		for(int i=1; i<(1<<N); i++) {
			// 2^N - 1
			int sum = 0;
			for(int j=0; j<N; j++) {
				// ��� ����� ���� üũ���ش�...
				if( (i&(1<<j)) != 0 ) {
					sum += number[j];
				}
			}
			if(sum == S) {
				ans += 1;
			}
		}
		
		System.out.println(ans);
		
	}
}
