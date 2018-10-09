package NHN.P2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class nhn2 {

   public static void main(String[] args) throws IOException {
      try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
         String firstLine = br.readLine();
         int n = Integer.parseInt(firstLine.split(" ")[0]);
         final int cycle = Integer.parseInt(firstLine.split(" ")[1]);
         String[][] arr = new String[n][n];
         for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().trim().split(" ");
         }
            
        int start = 0;
        int limit = n - 1;
        int realCycle = cycle % (4 * limit);
        while (start != n / 2) {
           if (realCycle == 0) {
              start++;
              limit--;
              realCycle = -cycle % (4 * limit);
              continue;
           }
           List<String> temp = new ArrayList<>();
           int i = start, j = start;
           for (; j < limit; j++)
              temp.add(arr[i][j]);
           for (; i < limit; i++)
              temp.add(arr[i][j]);
           for (; j > start; j--)
              temp.add(arr[i][j]);
           for (; i > start; i--)
              temp.add(arr[i][j]);
           temp = rotate(temp, realCycle);
           int index = 0;

           i = j = start;
           for (; j < limit; j++) {
              arr[i][j] = temp.get(index);
              index++;
           }
           for (; i < limit; i++) {
              arr[i][j] = temp.get(index);
              index++;
           }
           for (; j > start; j--) {
              arr[i][j] = temp.get(index);
              index++;
           }
           for (; i > start; i--) {
              arr[i][j] = temp.get(index);
              index++;
           }
           start++;
           limit--;
           if (limit == 0)
               break;
           realCycle = -cycle % (4 * limit);
        }

         int count1 = 0;
         for (String[] row : arr) {
            count1++;
            int count2 = 0;
            for (String name : row) {
               count2++;
               System.out.print(name);
               if (count2 != n)
                  System.out.print(" ");
            }
            if (count1 != n)
               System.out.println();
         }

      }
   }

   public static List<String> rotate(List<String> list, int cycle) {
      List<String> result = new ArrayList<>();
      int len = list.size();
      if (cycle < 0) {
         cycle *= -1;
         result.addAll(list.subList(cycle, len));
         result.addAll(list.subList(0, cycle));
      } else {
         result.addAll(list.subList(len - cycle, len));
         result.addAll(list.subList(0, len - cycle));
      }

      return result;
   }
}