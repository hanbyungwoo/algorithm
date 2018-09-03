package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW2383_점심식사시간 {
	static int N, P;
	static int[][] map;
	static int[] AStair, BStair;
	static boolean[] list;
	static ArrayList<Integer> AList = new ArrayList<Integer>();
	static ArrayList<Integer> BList = new ArrayList<Integer>();
	
	static int min;
    static int index;
    public static void main(String[] args) throws IOException {
    	/*
         * Declaration
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(in.readLine().trim());
 
        for (int t=1; t<=T; t++) {
            /*
             * Input Data
             */
            N = Integer.parseInt(in.readLine().trim());
            map = new int[N][N];
 
            P = 0;
            int aRow = 0; int aCol = 0; int bRow = 0; int bCol = 0;
            boolean flag = false;
            for (int i=0; i<N; i++) {
                token = new StringTokenizer(in.readLine().trim());
                for (int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                    if (map[i][j] > 1) {
                        if (!flag) {
                        	// A시간 만큼의 배열 길이 생성
                            AStair = new int[map[i][j]];
                            aRow = i; aCol = j;
                            flag = true;
                        } else {
                        	// B시간 만큼의 배열 길이 생성
                            bRow = i; bCol = j;
                            BStair = new int[map[i][j]];
                        }
                    }
                }
            }
 
            /*
             * Solve - BackTracking
             */
            // Distance List
            AList.clear(); BList.clear();
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (map[i][j] == 1) {
                        AList.add(Math.abs(i-aRow)+Math.abs(j-aCol));
                        BList.add(Math.abs(i-bRow)+Math.abs(j-bCol));
                    }
                }
            }
            P = AList.size();
            list = new boolean[P];
            min = Integer.MAX_VALUE;
 
            recur(0);
 
            /*
             * Output Data
             */
            ans.append("#"+t+" "+min+"\n");
        }
        System.out.println(ans.toString());
    }
 
    static void recur(int depth) {
        // BREAKING POINT
        if (depth == P) {
            method();
            return;
        }
 
        // SELECT A
        list[depth] = true;
        recur(depth+1);
 
        // SELECT B
        list[depth] = false;
        recur(depth+1);
    }
 
    static void method() {
        // METHOD
        int time = 1;
        int AFinish = 0; int BFinish = 0;
        int AListCount = 0; int BListCount = 0;
        int AWait = 0; int BWait = 0;
        for (int i=0; i<P; i++) {
            if (list[i])  AListCount++;
            else          BListCount++;
        }
        // 진짜 걍 1부터 20까지 증가되는 중
        while (time <= 20) {
            // MOVE TO THE ENTRANCE
            for (int k=0; k<P; k++) {
            	// A까지 오는 사람의 시간을 보자
                if (list[k] && AList.get(k) == time) {
                    AFinish++;
                    AWait++;
                }
                // B까지 오는 사람의 계산한 시간을 보자
                if (!list[k] && BList.get(k) == time) {
                    BFinish++;
                    BWait++;
                }
            }
 
            // TIME COUNT
            time++;
            if (time >= min) {
                return;
            }
            // DECLINE STAIR
            // 계단 걸리는 시간
            for (int i=AStair.length-1; i>0; i--) {
                AStair[i] = AStair[i-1];
            }
            for (int i=BStair.length-1; i>0; i--) {
                BStair[i] = BStair[i-1];
            }
            int ACount = 0; int BCount = 0;
            for (int i=1; i<AStair.length; i++) {
                ACount += AStair[i];
            }
            for (int i=1; i<BStair.length; i++) {
                BCount += BStair[i];
            }
             
            AStair[0] = BStair[0] = 0;
            while (ACount < 3) {
                if (AWait > 0) {
                    AStair[0]++;
                    ACount++;
                    AWait--;
                } else {
                    break;
                }
            }
            while (BCount < 3) {
                if (BWait > 0) {
                    BStair[0]++;
                    BCount++;
                    BWait--;
                } else {
                    break;
                }
            }
             
            // ISFINISHED
            if (AFinish == AListCount && BFinish == BListCount) {
                if (ACount == 0 && BCount == 0) {
                    min = Math.min(min, time);
                    break;
                }
            }
        }
    }
}
 
