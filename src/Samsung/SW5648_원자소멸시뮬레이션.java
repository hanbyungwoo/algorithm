package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// https://whereisusb.tistory.com/187
public class SW5648_���ڼҸ�ùķ��̼� {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            int n = Integer.parseInt(br.readLine());
            Pair[] arr = new Pair[n];
            for(int j=0;j<n;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j] = new Pair(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
            }
            sb.append("#"+i+" "+solve(arr)+"\n");
        }        
        System.out.print(sb);
    }

    // 0~2000 (������ �Ը�) 0.5�ʸ� �����ϱ� ���� *2�� �ؼ� ũ�⵵ 0~4000��������.
    static int[][] map = new int[4001][4001]; 
    private static int solve(Pair[] arr) {
        Queue<Pair> queue = new LinkedList<>();
        // 0~4000 ���� ����ϱ� ���ؼ� 4001��
        for(int i=0;i<arr.length;i++) {
            // �־��� ��ǥ�� �迭�� x y������ �ٸ��� ������ ��ȯ
            // -�� ���ֱ� ���� +1000
            int x = arr[i].y+1000;
            int y = arr[i].x+1000;
            int d = arr[i].d;
            int k = arr[i].k;
            if(k==0) k=101;
            // 0.5ĭ���� ������ ���� �����ϱ� ���ؼ� *2 (0~4000)
            // �迭 �� x�� 0 ���� �����ϴ� ������
            queue.add(new Pair(4000-x*2, y*2, d, k));
            map[4000-x*2][y*2] = k;
        }
        int cntZero = 0;
        int result = 0;
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            // �̵��Ϸ��� �ϴµ� �ڽ��� K ���� ũ�� �浹�� �Ͼ ��.
            if(map[t.x][t.y]>t.k) {
                if(t.k==101) result-=101;
                result+=map[t.x][t.y];
                map[t.x][t.y] = 0;
                continue;
            }
            int tx = t.x;
            int ty = t.y;
            switch(t.d) {	// ����
            case 0: tx-=1; break;
            case 1:    tx+=1; break;
            case 2:    ty-=1; break;
            case 3:    ty+=1; break;
            }
            if(tx<0 || ty<0 || tx>4000 || ty>4000) {
                map[t.x][t.y] = 0;
                continue;
            }
            // �ش� ��ǥ�� ���� �ִٸ�
            if(map[tx][ty]!=0) {
                if(t.k==101) cntZero++;
                map[tx][ty] += t.k;
                map[t.x][t.y] = 0;
            }else {
            // ���� ���ٸ�
                map[tx][ty] = t.k;
                map[t.x][t.y] = 0;
                queue.add(new Pair(tx, ty, t.d, t.k));
            }
        }
        // zero �߶��ֱ�
        result -= cntZero*101;
        return result;
    }
    
    static class Pair{
        private int x,y,k,d;
        public Pair(int x,int y,int d,int k) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.k = k;
        }
    }
}

