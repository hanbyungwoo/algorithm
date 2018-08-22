package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A15684_��ٸ����� {
	static int N, M, H;
	static int map[][];
	static int result = -1;
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());	// ���μ�
		M = Integer.parseInt(st.nextToken());	// �� �ߴ� ���μ�
		H = Integer.parseInt(st.nextToken());	// ���� ���μ�
	
		map = new int[H+1][N+1];

		if(M==0) {
			System.out.println(0);
			return;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;		// �� �׾��� ���
			map[x][y+1] = 2;	// �� �׾��� ����
		}
		
		// �� 3�� ���� MAX�� ���� �� �ֱ� ������ 3���� ����.
		for(int i=0; i<4; i++) {
			dfs(0, i);
			if(result != -1) {
				break;
			}
		}
		System.out.println(result);
	}
	
	public static void dfs(int cnt, int total) {
		if(result != -1) {
			return;
		}
		// ���� �� �ִ� ���� �� ���� ���
		if(cnt >= total) {
			for(int i=1; i<=N; i++) {	// ��ٸ� Ȯ��
				int tmp = i;
				for(int j=1; j<=H; j++) {
					if(map[j][tmp] == 0) {
						continue;
					}
					if(map[j][tmp] > 0) {
						// 1�̸� ���ʿ��� ���������� �̵��ϹǷ� tmp(���μ���ġ) 1 ����
						// 2�̸� �����ʿ��� �������� �̵��ϹǷ� tmp(���μ���ġ) 1 ����
						if(map[j][tmp] == 1) {
							tmp++;
							continue;
						} else {
							tmp--;
							continue;
						}
						
					}
				}
				if(tmp == i) {
					// �ڽ��� ��ȣ���� ����ؼ� �ڽſ��� ����
					continue;
				} else {
					// ����
					return;
				}
			}
			result = total;
			return;
		}
		
		for(int i=1; i<N; i++) {	// ��ٸ� Ȯ��
			for(int j=1; j<=H; j++) {
				if(map[j][i]==0 && map[j][i+1]==0) {
					map[j][i] = 1;
					map[j][i+1] = 2;
					dfs(cnt+1, total);
					map[j][i] = 0;
					map[j][i+1] = 0;
				}
			}
		}
	}
}