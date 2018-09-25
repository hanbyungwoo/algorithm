package Kakao.P2018;

import java.util.LinkedList;
import java.util.List;

public class P1_4_무지의먹방라이브 {
	public static void main(String args[]) {
//		solution(new int[]{3,1,2}, 5);
		solution(new int[]{1,6,2}, 9);
		solution(new int[]{100,200,300,400,500}, 1000);
	}
	
	
	public static int solution(int[] food_times, long k) {
		List<Food> foods = new LinkedList<>();
        int nFoods = food_times.length;
        for (int i = 0; i < nFoods; i++) {
            foods.add(new Food(i + 1, food_times[i]));
        }

        long remainingTime = k;
        while (!foods.isEmpty()) {
            int nRemainingFoods = foods.size();
            int eachTimes = (int) (remainingTime / nRemainingFoods);
            remainingTime = remainingTime % nRemainingFoods;
            if (eachTimes == 0) {
//            	System.out.println(foods.get((int) remainingTime).id);
                return foods.get((int) remainingTime).id;
            }

            long overflow = eatEach(foods, eachTimes);
            remainingTime += overflow;
        }
//        System.out.println(-1);
        return -1;
    }
	
	// 일단 몫만큼 다 빼주고 그 때 기존의 숫자보다 -가 된다면 삭제해주고 그 -된 수치를 다시 더해줌..
	private static long eatEach(List<Food> foods, int t) {
        long overflow = 0;
        for (Food f : foods) {
            f.remainingTime -= t;
            if (f.remainingTime < 0) {
                overflow += -f.remainingTime;
            }
        }
        foods.removeIf(f -> f.remainingTime <= 0);
        return overflow;
    }

}

class Food {
    public int id;
    public int remainingTime;

    public Food (int id_, int t) {
        id = id_;
        remainingTime = t;
    }
}

