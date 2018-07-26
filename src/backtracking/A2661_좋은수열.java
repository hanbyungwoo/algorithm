package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2661_�������� {
	static int num;
	static boolean stop = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num = Integer.parseInt(st.nextToken());
		
		dfs(1, "1");

	}
	
	public static void dfs(int depth, String s) {
		if(stop) {
			return;
		}
		if(depth == num) {
			// �� ó���� ������ ���� �ּҰ���.
			stop = true;
			System.out.println(s);
		} else {
			for(int i=1; i<4; i++) {
				if(isSatisfy(s+i)) {
					dfs(depth+1, s+i);
				}
			}
		}
	}
	
	public static boolean isSatisfy(String s) {
		// ���ڰ� �ϳ��� �߰��ɶ� ���� �����ϴ��� �˻����ش�.
		// �׷��� ������ ���ڿ� ������ 1/2�� Ȯ�����ָ�ȴ�.
		// ���� : 123123
		// ù��° �� : 1231 (2 3)
		// �ι�° �� : 12 (31 23)	--> 12 31�� �񱳾��ϴ� ������ �̹� �� ���� �񱳸� �ؼ� 6�� ���̱��� �Ѿ�� �͵���
		// ����° �� : (123 123)
		int len = s.length();
		int loop = len / 2;
		int start = len - 1;
		int end = len;
		
		for(int i = 1; i <= loop; i++) {
			if(s.substring(start-i, end-i).equals(s.substring(start, end))) {
				return false;
			}
			start -= 1;
		}
		
		return true;
		
	}
}

