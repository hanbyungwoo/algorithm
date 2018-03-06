import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//https://www.acmicpc.net/problem/11724

// �����ҿ� ���õ� ����

// ����
// ���� ���� �׷����� �־����� ��, ���� ��� (Connected Component)�� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

// �Է�
//ù° �ٿ� ������ ���� N�� ������ ���� M�� �־�����. (1 �� N �� 1,000, 0 �� M �� N��(N-1)/2) ��° �ٺ��� M���� �ٿ� ������ �� ���� u�� v�� �־�����.
//(1 �� u, v �� N, u �� v) ���� ������ �� ���� �־�����.

//���
//ù° �ٿ� ���� ����� ������ ����Ѵ�.

//���� �Է� 
//6 5	// edge vector
//1 2
//2 5
//5 1
//3 4
//4 6

// ���
//2

public class A11724 {
	static ArrayList<Integer>[] a;
	static boolean []c;
	static int cnt;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int edge = sc.nextInt();
		int vector = sc.nextInt();
		a = (ArrayList<Integer>[]) new ArrayList[edge+1];
		for(int i=1; i<=edge; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<=vector; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		
		for(int i=1; i<=edge; i++) {
			Collections.sort(a[i]);
		}
		
		c = new boolean[edge+1];
		cnt = 0;
		for(int i=1; i<=edge; i++) {
			if(c[i]==false) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
		
		
	}
	public static void dfs(int x) {
		if(c[x]) {
			return;
		}
		c[x] = true;
		for(int y : a[x]) {
			if(c[y] == false) {
				dfs(y);
			}
		}
	}
}
