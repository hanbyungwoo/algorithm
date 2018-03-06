import java.util.*;

//문제
//그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
//단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
//
//입력
//첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
//다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 한 간선이 여러 번 주어질 수도 있는데, 간선이 하나만 있는 것으로 생각하면 된다. 입력으로 주어지는 간선은 양방향이다.
//
//출력
//첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

public class graph {
    static ArrayList<Integer>[] a;
    static boolean[] c;
//    public static void dfs(int x) {
//        if (c[x]) {
//            return;
//        }
//        c[x] = true;
//        System.out.print(x + " ");
//        for (int y : a[x]) {
//            if (c[y] == false) {
//                dfs(y);
//            }
//        }
//    }
//    public static void bfs(int start) {
//        Queue<Integer> q = new LinkedList<Integer>();
//        q.add(start);
//        c[start] = true;
//        while (!q.isEmpty()) {
//            int x = q.remove();
//            System.out.print(x + " ");
//            for (int y : a[x]) {
//                if (c[y] == false) {
//                    c[y] = true;
//                    q.add(y);
//                }
//            }
//        }
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int start = sc.nextInt();
//        a = (ArrayList<Integer>[]) new ArrayList[n+1];
//        for (int i=1; i<=n; i++) {
//            a[i] = new ArrayList<Integer>();
//        }
//        for (int i=0; i<m; i++) {
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            a[u].add(v);
//            a[v].add(u);
//        }
//        for (int i=1; i<=n; i++) {
//            Collections.sort(a[i]);
//        }
//        c = new boolean[n+1];
//        dfs(start);
//        System.out.println();
//        c = new boolean[n+1];
//        bfs(start);
//        System.out.println();
//    }
    public static void dfs(int x) {
    	if(c[x]) {
    		return;
    	}
    	c[x] = true;
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
	    	for(int y : a[pop]) {
	    		if(c[y] == false) {
	    			c[y] = true;	    			
	    			q.add(y);
	    		}
	    	}
    	}
    	
    }
    
    public static void main (String args[]) {
    	
    	Scanner sc = new Scanner(System.in);
    	int edge = sc.nextInt();
    	int vector = sc.nextInt();
    	int start = sc.nextInt();
    	a= (ArrayList<Integer>[]) new ArrayList[edge+1];
    	for(int i=1; i<=edge; i++) {
    		a[i] = new ArrayList<Integer>();
    	}
    	
    	for(int i=0; i<vector; i++) {
    		int x = sc.nextInt();
    		int y = sc.nextInt();
    		a[x].add(y);
    		a[y].add(x);
    	}
    	
    	for(int i=1; i<=edge; i++) {
    		Collections.sort(a[i]);
    	}
    	
    	c = new boolean[edge+1];
    	dfs(start);
    	System.out.println();
    	c = new boolean[edge+1];
    	bfs(start);
    	  	
    }
    
    
}