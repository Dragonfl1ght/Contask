package org.tasks.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    private static int findMedian(List<Integer> n) {
        int[] sortedNums = new int[n.size()];
        for (int i = 0; i < n.size(); i++) {
            sortedNums[i] = n.get(i);
        }
        Arrays.sort(sortedNums);

        int medianIndex = sortedNums.length / 2;
        if (sortedNums.length % 2 == 0) {
            return (sortedNums[medianIndex - 1] + sortedNums[medianIndex]) / 2;
        } else {
            return sortedNums[medianIndex];
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("You need to enter 1 argument");
            return;
        }

        List<Integer> nums = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            while (scanner.hasNext()) {
               nums.add(scanner.nextInt());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
            return;
        }

        int med = findMedian(nums);
        int sum = 0;
        for(Integer n: nums){
            sum += Math.abs(n - med);
        }
        System.out.println(sum);
    }

}
