package org.tasks.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("You need to enter 2 arguments");
            return;
        }

        double cx, cy, r;
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            cx = scanner.nextFloat();
            cy = scanner.nextFloat();
            r = scanner.nextFloat();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
            return;
        }

        List<Point> points = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(args[1]));
            while (scanner.hasNext()) {
                float x = scanner.nextFloat();
                float y = scanner.nextFloat();
                points.add(new Point(x, y));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[1]);
            return;
        }

        for (Point p : points) {
            double dist = Math.sqrt(Math.pow(p.getX() - cx, 2) + Math.pow(p.getY() - cy, 2));
            if (dist == r) {
                System.out.println("0");
            } else if (dist < r) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
    }

    static class Point {
        private float x;
        private float y;

        public void setX(float x) {
            this.x = x;
        }

        public void setY(float y) {
            this.y = y;
        }

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }
    }
}
