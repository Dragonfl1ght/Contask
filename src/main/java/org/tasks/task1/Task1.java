package org.tasks.task1;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
        public static void main(String[] args) {
            if (args.length < 2) {
                System.out.println("Must be to arguments: n and m");
                return;
            }

            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);

            if (n <= 0 || m <= 0) {
                System.out.println("Arguments must be positive numbers");
                return;
            }

            int[] circularArray = new int[n];
            for (int i = 0; i < n; i++) {
                circularArray[i] = i + 1;
            }

            int startIndex = 0;
            List<Integer> path = new ArrayList<>();
            while (path.size() < n) {
                int endIndex = (startIndex + m - 1) % n;
                path.add(circularArray[startIndex]);
                startIndex = endIndex;
            }
            for(int element : path) {
                System.out.print(element);
            }
        }
}

