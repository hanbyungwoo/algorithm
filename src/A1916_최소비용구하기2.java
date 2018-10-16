import java.util.*;

public class A1916_�ּҺ�뱸�ϱ�2 {
    static final int inf = 1000000000;
    static int n;
    static int a[][];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                a[i][j] = inf;
            }
        }
        int m = sc.nextInt();
        for (int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            if (a[x][y] > z) {
                a[x][y] = z;
            }
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        dijkstra(start, end);
       
    }
    
    public static void dijkstra(int start, int end) {
    	 int[] d = new int[n+1];
         boolean[]c = new boolean[n+1];
         for (int i=1; i<=n; i++) {
             d[i] = inf;
             c[i] = false;
         }
         d[start] = 0;
         PriorityQueue<Integer> pq = new PriorityQueue<>();
         pq.add(start);
         a[start][start] = 0;
         int before;
         while(!pq.isEmpty()) {
        	 before = pq.poll();
        	 for(int i=1; i<=n; i++) {
        		 if(d[i] > a[before][i] + d[before]) {
        			 d[i] = a[before][i] + d[before];
        			 pq.add(i);
        		 }
        	 }
         }
         System.out.println(d[end]);
    }
}