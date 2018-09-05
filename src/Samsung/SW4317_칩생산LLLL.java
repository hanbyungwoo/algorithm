package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW4317_Ä¨»ý»êLLLL {
	static int h, w, max;
	static char mm[][][];
	static int map[][];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new int[26][10];
			mm = new char[26][ 1<<10 ][ 1<<10 ];
			
			for(int i=0; i<w; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=h; j++) {
					map[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+ca+" "+so(1));
			in(1);
			ca++;
		}
	}
	
	public static int ma(int a, int b){return a>b?a:b;}
	 
	public static int cc(int x){
	    int cn = 0;
	    for(int i=0; i<w;i++){
	        cn = (cn << 1);
	        if(map[x][i]==2)
	            cn++;
	    }
	    return cn;
	}
	 
	
	public static int so(int x){
	    if(x==h)
	        return 0;
	    int cn = cc(x);
	    int cn1 = cc(x-1);
	    if(mm[x-1][cn][cn1] == 0){
	        mm[x-1][cn][cn1] = (char)so2(x,0);
	    }
	    return mm[x-1][cn][cn1];
	}
	 
	public static int so2(int x, int y){
	    int temap = 0;
	    for(int i = y; i< w-1; i++){
	        if(map[x][i] == 0 && map[x+1][i] == 0 && map[x][i+1] ==0 && map[x+1][i+1] == 0){
	            map[x][i] = 2;
	            map[x+1][i] = map[x][i+1] = map[x+1][i+1] = 1;
	            temap = ma(temap,so2(x,i)+1);
	            map[x][i] = map[x+1][i] = map[x][i+1] = map[x+1][i+1] = 0;
	        }
	    }
	    temap = ma(temap,so(x+1));
	    return temap;
	}
	 
	
	public static void in(int x){
	    if(x==h)
	        return;
	    int cn = cc(x);
	    int cn1 = cc(x-1);
	    if(mm[x-1][cn][cn1] != 0){
	        mm[x-1][cn][cn1] = 0;
	        in2(x,0);
	    }
	}
	 
	public static void in2(int x, int y){
	    for(int i = y; i< w-1; i++){
	        if(map[x][i] == 0 && map[x+1][i] == 0 && map[x][i+1] ==0 && map[x+1][i+1] == 0){
	            map[x][i] = 2;
	            map[x+1][i] = map[x][i+1] = map[x+1][i+1] = 1;
	            in2(x,i);
	            map[x][i] = map[x+1][i] = map[x][i+1] = map[x+1][i+1] = 0;
	        }
	    }
	    in(x+1);
	}
	
}






