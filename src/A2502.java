
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
		
		// (계수의 값만 저장해놓고 밑에 for문을 돌면서 몇 개인지 파악함)
		// 1일 : A / 2일 : B / 3일 : A+B / 4일 : A+2B / 5일 : 2A+3B / 6일 : 3A+5B / ...
		// 배열로 표시할 경우
		// A : 1 0 1 1 2 3 5 8 ...
		// B : 0 1 1 2 3 5 8 13 ...
		
		A[0] = 1; A[1] = 0;
		B[0] = 0; B[1] = 1;
		
		for(int i=2; i<D; i++) {
			A[i] = A[i-1] + A[i-2];
			B[i] = B[i-1] + B[i-2];
		}
		
		// 1<=A<=B이다. -> 그러므로  i(구하려는 A값)이 최대 K/2일 것이라고 생각했다. 
		for(int i=1; i<=K/2; i++) {
			for(int j=i; j<=K; j++) {
				// 계수에다가 i와 j를 곱해 K와 일치하는지 비교
				if(K == (i*A[D-1] + j*B[D-1])) {
					System.out.println(i);
					System.out.println(j);
				}
				// 초과 되었을 경우는 break;
				else if(K < (i*A[D-1] + j*B[D-1])) {
					break;
				}
			}
		}
		
	}
}
