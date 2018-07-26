package backtracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2580 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int map[][] = new int[9][9];
		boolean check[][][] = new boolean[3][9][10];
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					check[0][i][map[i][j]] = true;
					check[1][j][map[i][j]] = true;
					check[2][square(i,j)][map[i][j]] = true;
				}
			}
		}
		
		go(map, check, 0);
		
	}
	
	public static int square(int x, int y) {
		return (x/3)*3+(y/3);
	}
	
	public static boolean go(int [][]map, boolean [][][] check, int index) {
		//123
		if (index == 81) {
            for (int i=0; i<9; i++) {
                for (int j=0; j<9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
		
		int x = index/9;
	    int y = index%9;
	    if (map[x][y] != 0) {
	    	return go(map, check, index+1);
	    }
	    else {
	    	for (int i=1; i<=9; i++) {
	            if (!check[0][x][i] && !check[1][y][i] && !check[2][square(x,y)][i]) {
	                check[0][x][i] = check[1][y][i] = check[2][square(x,y)][i] = true;
	                map[x][y] = i;
	                if (go(map, check, index+1)) {
	                    return true;
	                }
	                map[x][y] = 0;
	                check[0][x][i] = check[1][y][i] = check[2][square(x,y)][i] = false;
	            }
	        }
	    }
	    return false;
	}
}
