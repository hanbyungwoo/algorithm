package Kakao.P2018_CodeFestival;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A15954_������ {
	static int n, k;
	static double min;
	static int arr[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		min = Integer.MAX_VALUE;
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// k���� ������ �� ���� �� �ִ� ����
		for(int z=k; z<=n; z++) {
			
			for(int i=0; i<n-z+1; i++) {
				double avg=0;
				double bunsan=0;
				// ���ӵ� k��
				for(int j=i; j<i+z; j++) {
					avg += arr[j];
				}
				avg /= z;
				
				// �л� ���ϱ�
				for(int j=i; j<i+z; j++) {
					bunsan += Math.pow((arr[j]-avg), 2);
				}
				bunsan /= z;
				
				// ǥ������ ���ϱ�
				if(min > Math.sqrt(bunsan)) {
					min = Math.sqrt(bunsan);
				}
			}	
		}
		
		
		System.out.println(min);
	}
}