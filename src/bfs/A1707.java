package bfs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1707

// �̺б׷���
//����
//�׷����� ������ ������ �ѷ� �����Ͽ�, �� ���տ� ���� ���������� ���� �������� �ʵ��� ������ �� ���� ��, �׷��� �׷����� Ư���� �̺� �׷��� (Bipartite Graph) �� �θ���.
//
//�׷����� �Է����� �־����� ��, �� �׷����� �̺� �׷������� �ƴ��� �Ǻ��ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
//�Է�
//�Է��� ���� ���� �׽�Ʈ ���̽��� �����Ǿ� �ִµ�, ù° �ٿ� �׽�Ʈ ���̽��� ���� K(2��K��5)�� �־�����.
//�� �׽�Ʈ ���̽��� ù° �ٿ��� �׷����� ������ ���� V(1��V��20,000)�� ������ ���� E(1��E��200,000)�� �� ĭ�� ���̿� �ΰ� ������� �־�����.
//�� �������� 1���� V���� ���ʷ� ��ȣ�� �پ� �ִ�. �̾ ��° �ٺ��� E���� �ٿ� ���� ������ ���� ������ �־����µ�, �� �ٿ� ������ �� ������ ��ȣ�� �� ĭ�� ���̿� �ΰ� �־�����.
//
//���
//K���� �ٿ� ���� �Է����� �־��� �׷����� �̺� �׷����̸� YES, �ƴϸ� NO�� ������� ����Ѵ�.
// ����
//2		// �׽�Ʈ ���̽� ��
//3 2	// ����, ����
//1 3
//2 3
//4 4	// ����, ����
//1 2
//2 3
//3 4
//4 2
// ���
//YES
//NO
public class A1707 {
	static ArrayList<Integer>[] a;
	static boolean[] c;
	static int[] check;
	static boolean result;
	static int value;
	
	public static void dfs(int x, int color) {
		if(color == 0) {
			color = 1;
		} else {
			color = 0;
		}
		
		check[x] = color;
		for(int y : a[x]) {
			if(check[y] == color) {
				result = false;
				return;
			}
		}
		
		if(c[x]) {
			return;
		}
		c[x] = true;
		
		for(int y : a[x]) {
			if(c[y] == false) {
				
				dfs(y, check[x]);
			} 
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int i=0; i<testcase; i++) {
			int edge = sc.nextInt();
			int vector = sc.nextInt();
			a = (ArrayList<Integer>[]) new ArrayList[edge+1];
			for(int j=1; j<=edge; j++) {
				a[j] = new ArrayList<Integer>();
			}
			for(int j=1; j<=vector; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				a[x].add(y);
				a[y].add(x);
			}
			for(int j=1; j<=edge; j++) {
				Collections.sort(a[j]);
			}
			c = new boolean[edge+1];
			check = new int[edge+1];
			value = 0;
			result = true;
			for(int j=1; j<=edge; j++) {
				check[j] = 2;	// 2�� �ʱ�ȭ
			}
			
			
			for(int j=1; j<=edge; j++) {
				if(c[j]==false) {
					dfs(j, 0);
				}
			}
			
			if(result == false) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
			
		}
		
	}

}
