
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class A2502 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[D];
		arr[D-1] = K;
		int A[] = new int[D];
		int B[] = new int[D];
		
		// (����� ���� �����س��� �ؿ� for���� ���鼭 �� ������ �ľ���)
		// 1�� : A / 2�� : B / 3�� : A+B / 4�� : A+2B / 5�� : 2A+3B / 6�� : 3A+5B / ...
		// �迭�� ǥ���� ���
		// A : 1 0 1 1 2 3 5 8 ...
		// B : 0 1 1 2 3 5 8 13 ...
		
		A[0] = 1; A[1] = 0;
		B[0] = 0; B[1] = 1;
		
		for(int i=2; i<D; i++) {
			A[i] = A[i-1] + A[i-2];
			B[i] = B[i-1] + B[i-2];
		}
		
		// 1<=A<=B�̴�. -> �׷��Ƿ�  i(���Ϸ��� A��)�� �ִ� K/2�� ���̶�� �����ߴ�. 
		for(int i=1; i<=K/2; i++) {
			for(int j=i; j<=K; j++) {
				// ������ٰ� i�� j�� ���� K�� ��ġ�ϴ��� ��
				if(K == (i*A[D-1] + j*B[D-1])) {
					System.out.println(i);
					System.out.println(j);
				}
				// �ʰ� �Ǿ��� ���� break;
				else if(K < (i*A[D-1] + j*B[D-1])) {
					break;
				}
			}
		}
		
	}
}
