import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1722 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int num = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int seq=1;
		
		int choice = Integer.parseInt(st.nextToken());
		long fibo[] = new long[21];
		fibo[0] = 1;
		boolean bol[] = new boolean[num+1];
		fibo[1] = 1;
		long rst = 0;
		for(int i=2; i<21; i++) {
			fibo[i] = fibo[i-1]*i;
		}
		if(choice==1) {
			// 1 pick의 순서에 해당하는 순열 찾기 20번째.
			long pick = Long.parseLong(st.nextToken());
			int arr[] = new int[num+1];
			for(int i=0; i<num; i++) {
				for(int j=1; j<=num; j++) {
					if(bol[j]) continue;
					if(fibo[num-i-1] < pick) {
						pick -= fibo[num-i-1];
					} else {
						arr[i] = j;
						bol[j] = true;
						break;
					}
				}
			}
			for(int i=0; i<num; i++) {
				System.out.print(arr[i]+" ");
			}
			
		} else {
			// 2 해당 순열의 순서 찾기
			int arr2[] = new int[num];
			for(int i=0; i<num; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<num; i++) {
				for(int j=1; j<arr2[i]; j++) {
					if(bol[j]==false)
						rst += fibo[num-i-1];
				}
				bol[arr2[i]] = true;
			}
			System.out.println( rst + 1 );
		}
		
		
//		if(choice == 1) {
//			long pick = Long.parseLong(st.nextToken());
//			for(int i=1; i<pick; i++) {
//				next_per(num);
//			}
//			for(int i=0; i<num; i++) {
//				System.out.print(arr[i]+" ");
//			}
//		} else {	// choice 2인 경우.
//			int arr2[] = new int[num];
//			for(int i=0; i<num; i++) {
//				arr2[i] = Integer.parseInt(st.nextToken());
//			}
//			do {
//				int check=0;
//				for(int i=0; i<num; i++) {
//					if(arr[i] == arr2[i]) {
//						check++;
//					} else {
//						break;
//					}
//				}
//				if(check==num) {
//					System.out.println(seq);
//					break;
//				}
//				seq++;
//			}
//			while(next_per(num)); 
//			
//		}
		
		
	}
	
//	public static boolean next_per(int n) {
//		int i = n-1;
//		while(i>0 && arr[i-1] >= arr[i]) i--;
//		if(i <= 0) return false;
//		int j = n-1;
//		while(arr[j] <= arr[i-1]) j--; 
//		swap(j, i-1);
//		j = n-1;
//		while( i < j ) {
//			swap(i, j);
//			i++;
//			j--;
//		}
//		return true;
//	}
//	
//	static void swap(int a, int b) {
//		int temp = arr[a];
//		arr[a] = arr[b];
//		arr[b] = temp;
//	}
}
