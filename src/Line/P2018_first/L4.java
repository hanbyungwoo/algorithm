package Line.P2018_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// �Է�����
//2
//5 4 2
//1 1 1

// ���
//100
//1

// �ش� �κ� ����
//(39 / 13) mod 5 != (39 mod 5) / (13 mod 5)
public class L4 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// �׸�, ��ƼĿ
		// 5C2 �޺���̼����� �����ؼ� Ǯ����.
		int t = Integer.parseInt(st.nextToken());
		while(t-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int sticker = K-M;
			long temp = count(N)/(count(sticker)*count(N-sticker));
			long temp2 = count(N)/(count(M)*count(N-M));
			long value = temp*temp2%1003001;
			
			System.out.println(value);
			
		}
	}
    
    public static int count(int x) {
    	if(x==0) {
    		return 1;
    	}
    	for(int i=x-1; i>=1; i--) {
    		x *= i;
    		if(x>1003001) {
    			x %= 1003001;
    		}
    	}
    	return x;
    }
}
