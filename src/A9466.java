import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.acmicpc.net/problem/9466

public class A9466 {
	static int []a;	// array
	static int []d;	// distance
	static int []s;	// step
	static int n;
	
	public static int dfs(int x, int cnt, int step) {
	    if (d[x] != 0) {
	        if (step != s[x]) {
	            return 0;
	        }
	        return cnt-d[x];
	    }
	    d[x] = cnt;
	    s[x] = step;
	    return dfs(a[x], cnt+1, step);
	}
	public static void main(String args[]) {
	    Scanner sc = new Scanner(System.in);
	    
		int t = sc.nextInt();
	    
	    while (t-- > 0) {
	        n = sc.nextInt();
	        a = new int[n+1];
	        d = new int[n+1];
	        s = new int[n+1];
	        for (int i=1; i<=n; i++) {
	            a[i] = sc.nextInt();
	            d[i] = 0;
	            s[i] = 0;
	        }
	        int ans=0;
	        for (int i=1; i<=n; i++) {
	            if (d[i] == 0) {
	                ans += dfs(i, 1, i);
	            }
	        }
	        System.out.println(n-ans);
	    }
	}
	
}
