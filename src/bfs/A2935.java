package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A2935 {
	
	static final int MAX_VALUE = 1000000000;
    static int min = MAX_VALUE;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> floor = new ArrayList<>();
        ArrayList<ArrayList<Integer>> elevator = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            floor.add(new ArrayList<>());
        }

        for (int i = 0; i < M + 1; i++) {
            elevator.add(new ArrayList<>());
        }


        for (int i = 1; i <= M; i++) {

            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            while (X <= N) {
                floor.get(X).add(i); 	// Ãþ Á¤º¸ : °¢ Ãþ¸¶´Ù Å» ¼ö ÀÖ´Â ¿¤·¹º£ÀÌÅÍ
                elevator.get(i).add(X); // ¿¤·¹º£ÀÌÅÍ Á¤º¸ : ¿¤·¹º£ÀÌÅÍ¸¶´Ù °¥ ¼ö ÀÖ´Â °¢ Ãþ
                X += Y;
            }
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Info> pq = new PriorityQueue<Info>();
        
        int dist[] = new int [M+1];
        int prev[] = new int [M+1];
        Arrays.fill(dist, MAX_VALUE);
        for(int i=0; i<floor.get(A).size(); i++) {
        	pq.add(new Info(floor.get(A).get(i), 1));
        	dist[floor.get(A).get(i)] = 1;
        }
        
        while(!pq.isEmpty()) {
        	Info u = pq.poll();
        	if(dist[u.elevator] < u.dist) {
        		continue;
        	}
        	for (int i = 0; i < elevator.get(u.elevator).size(); i++) {

                int level = elevator.get(u.elevator).get(i);

                for (int j = 0; j < floor.get(level).size(); j++) {

                    int nextElevator = floor.get(level).get(j);

                    if (dist[nextElevator] > u.dist + 1) {

                        dist[nextElevator] = u.dist + 1;
                        prev[nextElevator] = u.elevator;

                        pq.add(new Info(nextElevator, dist[nextElevator]));
                    }
                }
            }
        }

        int lastElevator = 0;
        for (int i = 0; i < floor.get(B).size(); i++) {

            if (min > dist[floor.get(B).get(i)]) {

                min = dist[floor.get(B).get(i)];
                lastElevator = floor.get(B).get(i);
            }
        }

        if (min == MAX_VALUE) {

            System.out.println(-1);
        } else {

            System.out.println(min);
            print(prev, lastElevator);
        }
    }

    static void print(int[] prev, int elevator) {

        if (elevator == 0) return;
        print(prev, prev[elevator]);
        System.out.println(elevator);
    }



	static class Info implements Comparable<Info> {
		int elevator;
		int dist;
		public Info() {
			
		}
		public Info(int elevator, int dist) {
			this.elevator = elevator;
			this.dist = dist;
		}
		@Override
		public int compareTo(Info o) {
			return this.dist < o.dist ? -1 : 1;
		}
	}
	
}

