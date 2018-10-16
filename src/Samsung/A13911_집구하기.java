package Samsung;

import java.util.*;

public class A13911_집구하기 {
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
                a[y][x] = z;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
        	list.add(i);
        }
        
        int mac = sc.nextInt();
        int macdis = sc.nextInt();
        int maclist[] = new int[mac];
        for(int i=0; i<mac; i++) {
        	maclist[i] = sc.nextInt();
        	for(int j=0; j<list.size(); j++) {
        		if(list.get(j)==maclist[i]) {
        			list.remove(j);
        			break;
        		}
        	}
        }
        
        int star = sc.nextInt();
        int stardis = sc.nextInt();
        int starlist[] = new int[star];
        for(int i=0; i<star; i++) {
        	starlist[i] = sc.nextInt();
        	for(int j=0; j<list.size(); j++) {
        		if(list.get(j)==starlist[i]) {
        			list.remove(j);
        			break;
        		}
        	}
//        	list.remove(starlist[i]);
        }
        int min=inf;
        for(int i=0; i<list.size(); i++) {
        	int arr[] = dijkstra(list.get(i));
        	int macMin = macdis + 1;
        	for(int j=0; j<mac; j++) {
        		macMin = Math.min(arr[maclist[j]], macMin);
        	}
        	int starMin = stardis + 1;
        	for(int j=0; j<star; j++) {
        		starMin = Math.min(arr[starlist[j]], starMin);
        	}
        	if(macMin <= macdis && starMin <= stardis && macMin+starMin < min) {
        		min = macMin + starMin;
        	}
        }
        
        if(min == inf) {
        	System.out.println(-1);
        } else {
        	System.out.println(min);
        }
       
    }
    
    public static int[] dijkstra(int start) {
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
         
         return d;
//         System.out.println(d[end]);
    }
}