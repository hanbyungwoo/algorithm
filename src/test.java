import java.util.*;

//����
//�׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
//��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. ���� ��ȣ�� 1������ N�������̴�.
//
//�Է�
//ù° �ٿ� ������ ���� N(1 �� N �� 1,000), ������ ���� M(1 �� M �� 10,000), Ž���� ������ ������ ��ȣ V�� �־�����. 
//���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����. �� ������ ���� �� �־��� ���� �ִµ�, ������ �ϳ��� �ִ� ������ �����ϸ� �ȴ�. �Է����� �־����� ������ ������̴�.
//
//���
//ù° �ٿ� DFS�� ������ �����, �� ���� �ٿ��� BFS�� ������ ����� ����Ѵ�. V���� �湮�� ���� ������� ����ϸ� �ȴ�.

public class test {
	static ArrayList<Integer>[] a;
	static boolean[] c;
	public static void dfs(int x) {
		if(c[x]) {
			return;
		}
		c[x] = true;	// �ش� ���� ����Ѱ�
		System.out.print(x + " ");
		for(int y : a[x]) {
			if(c[y] == false) {
				dfs(y);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		c[start] = true;
		while(!q.isEmpty()) {
			int pop = q.remove();
			System.out.print(pop + " ");
			for(int y : a[pop])  {
				if(c[y] == false) {
					c[y] = true;
					q.add(y);
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
		
		a = (ArrayList<Integer>[])new ArrayList[line=1];
		for(int i=1; i<=point; i++) {	// ������ ������ŭ �迭����Ʈ�����
			a[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<line; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		for(int i=1; i<=point; i++) {
			Collections.sort(a[i]);
		}
		
		c = new boolean[point+1];
		dfs(start);
		System.out.println();

		c = new boolean[point+1];
		bfs(start);
		System.out.println();
		
		
	}
	
	
}