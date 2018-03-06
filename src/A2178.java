import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
//4 6
//101111
//101010
//101011
//111011
public class A2178 {
           static int [] up = {-1, 1, 0, 0};
           static int [] down = {0, 0, -1, 1};
           public static void main(String args[]) throws IOException {
                     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                     StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                     int h = Integer.parseInt(st.nextToken());
                     int r = Integer.parseInt(st.nextToken());
                    
                     int [][]map = new int[h+1][r+1];
                     int [][]check = new int[h+1][r+1];
                    
                     for(int i=1; i<=h; i++) {
                                String temp = br.readLine();
                                for(int j=1; j<=r; j++) {
                                          map[i][j] = temp.charAt(j-1)-'0';
                                           check[i][j] = -1;
                                }
                     }
                    
                     Queue<Point> q = new LinkedList<Point>();
                     q.add(new Point(1,1));
                     check[1][1] = 1;
                     while(!q.isEmpty()) {
                                int one = q.peek().x;
                                int two= q.peek().y;
                                q.remove();
                                for(int i=0; i<4; i++) {
                                          int tempOne = one + up[i];
                                          int tempTwo = two + down[i];
                                          if(tempOne > 0 && tempTwo > 0 && tempOne <= h && tempTwo <= r) {
                                                     if(map[tempOne][tempTwo] == 1 && check[tempOne][tempTwo] == -1 ) {
                                                                check[tempOne][tempTwo] = check[one][two] + 1;
                                                                q.add(new Point(tempOne, tempTwo));
                                                                if(tempOne == h && tempTwo == r) {
                                                                          System.out.println(check[tempOne][tempTwo]);
                                                                          return;
                                                                }
                                                     }
                                          }
                                }
                     }
                    
                    
           }
}
