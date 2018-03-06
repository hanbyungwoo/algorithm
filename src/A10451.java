import java.util.ArrayList;
import java.util.Scanner;

//https://www.acmicpc.net/problem/10451

//����
//
//1���� N���� ���� N���� �̷���� ������ ��Ÿ���� ����� ���������� �ִ�.
//���� ���, 8���� ���� �̷���� ���� (3, 2, 7, 8, 1, 4, 5, 6)�� �迭�� �̿��� ǥ���ϸ� (1234567832781456) �� ����.
//�Ǵ�, Figure 1�� ���� ���� �׷����� ��Ÿ�� ���� �ִ�.
//
//������ �迭�� �̿��� (1��i��n��1����i����n) �� ��Ÿ�´ٸ�, i���� ��i�� ������ �̾� �׷����� ���� �� �ִ�.
//
//Figure 1�� �����ִ� �� ó��, ���� �׷��� (3, 2, 7, 8, 1, 4, 5, 6) ���� �� 3���� ����Ŭ�� �ִ�. �̷��� ����Ŭ�� "���� ����Ŭ" �̶�� �Ѵ�.
//
//N���� ������ �̷���� ������ �־����� ��, ���� ����Ŭ�� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//
//�Է�
//ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����. �� �׽�Ʈ ���̽��� ù° �ٿ��� ������ ũ�� N (2 �� N �� 1,000)�� �־�����. ��° �ٿ��� ������ �־�����, �� ������ �������� ���еǾ� �ִ�.
//
//���
//�� �׽�Ʈ ���̽�����, �Է����� �־��� ������ �����ϴ� ���� ����Ŭ�� ������ ����Ѵ�.

//����
//2
//8
//3 2 7 8 1 4 5 6
//10
//2 1 3 4 5 6 7 9 10 8

//���
//3
//7

public class A10451 {
	static ArrayList<Integer>[] a;
	static boolean[] c;
	static int cnt;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int i=0; i<testcase; i++) {
			cnt = 0;
			int num = sc.nextInt();
			a=(ArrayList<Integer>[]) new ArrayList[num+1];
			for(int j=1; j<=num; j++) {
				a[j] = new ArrayList<Integer>();
			}
			for(int j=1; j<=num; j++) {
				int value = sc.nextInt();
				a[j].add(value);
			}
			
			c = new boolean[num+1];
			for(int j=1; j<=num; j++) {
				dfs(j);
			}
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int x) { 
		if(c[x]) {
			return;
		}
		c[x] = true;
		for(int y : a[x]) {
			if(c[y] == false) {
				dfs(y);
			} else {
				cnt++;
			}
		}
	}
}
