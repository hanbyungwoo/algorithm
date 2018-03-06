import java.util.*;

//https://www.acmicpc.net/problem/1753

//����
//����׷����� �־����� �־��� ���������� �ٸ� ��� ���������� �ִ� ��θ� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, ��� ������ ����ġ�� 10 ������ �ڿ����̴�. 
//
//
//�Է�
//ù° �ٿ� ������ ���� V�� ������ ���� E�� �־�����. (1��V��20,000, 1��E��300,000) ��� �������� 1���� V���� ��ȣ�� �Ű��� �ִٰ� �����Ѵ�.
//��° �ٿ��� ���� ������ ��ȣ K(1��K��V)�� �־�����. ��° �ٺ��� E���� �ٿ� ���� �� ������ ��Ÿ���� �� ���� ���� (u, v, w)�� ������� �־�����.
//�̴� u���� v�� ���� ����ġ w�� ������ �����Ѵٴ� ���̴�. u�� v�� ���� �ٸ��� w�� 10 ������ �ڿ����̴�. ���� �ٸ� �� ���� ���̿� ���� ���� ������ ������ ���� ������ �����Ѵ�.
//  u-(-w-)->v
//���
//ù° �ٺ��� V���� �ٿ� ����, i��° �ٿ� i�� ���������� �ִ� ����� ��ΰ��� ����Ѵ�. ������ �ڽ��� 0���� ����ϰ�, ��ΰ� �������� �ʴ� ��쿡�� INF�� ����ϸ� �ȴ�.


// ��¶����ΰŰ�����;;;
public class A1753 {
	static ArrayList<Integer>[] a;
	static ArrayList<Integer>[] distance;
	static int[] data;
	static boolean[] c;
	public static void dfs(int x) {
		if(c[x]) {
			return;
		}
		c[x] = true;	// �ش� ���� ����Ѱ�
		//System.out.print(x + " ");
		for(int i=1; i<=a[x].size(); i++) {
			if(c[a[x].get(i-1)] == false) {
				if(data[a[x].get(i-1)] > distance[x].get(i-1) + data[x]) {
					data[a[x].get(i-1)] = distance[x].get(i-1) + data[x];
					dfs(i);
				}
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		// ������ ����
		int point = sc.nextInt();
		// ������ ����
		int line = sc.nextInt();
		// �������� ����
		int start = sc.nextInt();
		
		a = (ArrayList<Integer>[])new ArrayList[line+1];
		distance = (ArrayList<Integer>[])new ArrayList[line+1];
		data = new int[point+1];
		for(int i=1; i<=point; i++) {	// ������ ������ŭ �迭����Ʈ�����
			a[i] = new ArrayList<Integer>();
			distance[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<line; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int dis = sc.nextInt();
			a[u].add(v);
			//a[v].add(u);
			distance[u].add(dis);
		}
		for(int i=1; i<data.length; i++) {
			data[i] = 999;
		}
//		for(int i=1; i<=point; i++) {
//			Collections.sort(a[i]);
//		}
		c = new boolean[point+1];
		data[start] = 0;
		dfs(start);
//		System.out.println(data[start]);
		for(int i=1; i<data.length; i++) {
			if(data[i] == 999) {
				System.out.println("INF");
			} else {
				System.out.println(data[i]);
			}
		}
		System.out.println();
		
	}
	
	
}