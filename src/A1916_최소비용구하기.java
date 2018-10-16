import java.util.*;

public class A1916_최소비용구하기 {
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
         for (int k=0; k<n-1; k++) {
             int min = inf+1;
             int x = -1;
             for (int i=1; i<=n; i++) {
                 if (c[i] == false && min > d[i]) {
                     min = d[i];
                     x = i;
                 }
             }
             c[x] = true;
             for (int i=1; i<=n; i++) {
                 if (d[i] > d[x] + a[x][i]) {
                     d[i] = d[x] + a[x][i];
                 }
             }
         }
         System.out.println(d[end]);
    }
}